package pl.wsb.fitnesstracker.training.internal;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.wsb.fitnesstracker.training.api.*;
import pl.wsb.fitnesstracker.user.api.User;
import pl.wsb.fitnesstracker.user.api.UserProvider;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class TrainingServiceImpl implements TrainingProvider, TrainingService {
    private final TrainingRepository trainingRepository;
    private final TrainingMapper trainingMapper;
    private final UserProvider userProvider;
    @Override
    public Optional<User> getTraining(final Long trainingId) {
        throw new UnsupportedOperationException("Not finished yet");
    }

    @Override
    public List<Training> getAllTrainings() {
        return trainingRepository.findAll();
    }

    @Override
    public List<Training> getUserTrainings(Long userId) {
        return trainingRepository.findAll()
                .stream().filter(training -> {return training.getUser().getId()==userId;}).toList();
    }

    @Override
    public List<Training> listTrainingByDate(Date date) {
        return trainingRepository.findAll()
                .stream().filter((training -> {return training.getEndTime().after(date);})).toList();
    }

    @Override
    public List<Training> listTrainingByActivity(ActivityType activityType) {
        return trainingRepository.findAll()
                .stream().filter((training -> {return training.getActivityType().equals(activityType);})).toList();
    }

    @Override
    public Training createTraining(TrainingShortDto trainingShortDto) {
        Optional<User> user = userProvider.getUser(trainingShortDto.userId());
        TrainingDto trainingDto = new TrainingDto(trainingShortDto.id(),user.get(),trainingShortDto.startTime(),trainingShortDto.endTime(),trainingShortDto.activityType(),trainingShortDto.distance(),trainingShortDto.averageSpeed());
        Training training = trainingMapper.toEntity(trainingDto);
        log.info("Creating User {}", training);
        if (training.getId() != null) {
            throw new IllegalArgumentException("User has already DB ID, update is not permitted!");
        }
        return trainingRepository.save(training);
    }

    @Override
    public Training updateTraining(Long id, TrainingShortDto trainingShortDto) {
        Optional<User> user = userProvider.getUser(trainingShortDto.userId());
        TrainingDto trainingDto = new TrainingDto(trainingShortDto.id(),user.get(),trainingShortDto.startTime(),trainingShortDto.endTime(),trainingShortDto.activityType(),trainingShortDto.distance(),trainingShortDto.averageSpeed());
        //Training training = trainingMapper.toEntity(trainingDto);
        Optional<Training> training = trainingRepository.findById(id);
        if (training.isEmpty()){
            throw new IllegalArgumentException("Training not found");
        }
        Training existingTraining = training.get();
        existingTraining.setUser(trainingDto.user());
        existingTraining.setActivityType(trainingDto.activityType());
        existingTraining.setDistance(trainingDto.distance());
        existingTraining.setEndTime(trainingDto.endTime());
        existingTraining.setAverageSpeed(trainingDto.averageSpeed());
        existingTraining.setStartTime(trainingDto.startTime());
        return trainingRepository.save(existingTraining);
    }

}
