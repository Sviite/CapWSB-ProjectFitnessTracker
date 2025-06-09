package pl.wsb.fitnesstracker.training.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.wsb.fitnesstracker.training.api.Training;
import pl.wsb.fitnesstracker.training.api.TrainingDto;
import pl.wsb.fitnesstracker.training.api.TrainingProvider;
import pl.wsb.fitnesstracker.training.api.TrainingShortDto;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/trainings")
@RequiredArgsConstructor
class TrainingController {

    private final TrainingServiceImpl trainingService;
    private final TrainingMapper trainingMapper;


    @GetMapping
    public List<TrainingDto> getAllTrainings() {
        return trainingService.getAllTrainings()
                .stream()
                .map(trainingMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public List<TrainingDto> getUserTrainings(@PathVariable Long id) {
        return trainingService.getUserTrainings(id)
                .stream()
                .map(trainingMapper::toDto)
                .toList();
    }

    @GetMapping("/finished/{afterTime}")
    public List<TrainingDto> listTrainingByDate(@PathVariable Date afterTime) {
        return trainingService.listTrainingByDate(afterTime)
                .stream()
                .map(trainingMapper::toDto)
                .toList();
    }

    @GetMapping("/activityType")
    public List<TrainingDto> listTrainingByActivity(@RequestParam ActivityType activityType) {
        return trainingService.listTrainingByActivity(activityType)
                .stream()
                .map(trainingMapper::toDto)
                .toList();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TrainingDto createTraining(@RequestBody TrainingShortDto trainingShortDto) {
        Training savedTraining = trainingService.createTraining(trainingShortDto);
        return trainingMapper.toDto(savedTraining);
    }
    @PutMapping("/{id}")
    public TrainingDto updateTraining(@PathVariable Long id, @RequestBody TrainingShortDto trainingShortDto) {
        Training updatedTraining = trainingService.updateTraining(id, trainingShortDto);
        return trainingMapper.toDto(updatedTraining);
    }
}