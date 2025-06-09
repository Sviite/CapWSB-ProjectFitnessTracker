package pl.wsb.fitnesstracker.training.internal;

import org.springframework.web.bind.annotation.RequestBody;
import pl.wsb.fitnesstracker.training.api.Training;
import pl.wsb.fitnesstracker.training.api.TrainingDTO;
import pl.wsb.fitnesstracker.training.api.TrainingProvider;
import pl.wsb.fitnesstracker.training.api.TrainingService;
import pl.wsb.fitnesstracker.user.api.User;
import pl.wsb.fitnesstracker.user.api.UserDto;

import java.util.Date;
import java.util.List;
import java.util.Optional;

// TODO: Provide Implementation and correct the return type of the method getTraining
public class TrainingServiceImpl implements TrainingProvider, TrainingService {

    @Override
    public Optional<User> getTraining(final Long trainingId) {
        throw new UnsupportedOperationException("Not finished yet");
    }

    @Override
    public List<Training> getAllTrainings() {
        return List.of();
    }

    @Override
    public List<Training> getUserTrainings(Long userId) {
        return List.of();
    }

    @Override
    public List<Training> listTrainingByDate(Date date) {
        return List.of();
    }

    @Override
    public Training createTraining(TrainingDTO trainingDTO) {
          return null;
    }

    @Override
    public Training updateTraining(TrainingDTO trainingDTO, long id) {
        return null;

    }

}
