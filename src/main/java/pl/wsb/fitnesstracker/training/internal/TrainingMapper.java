package pl.wsb.fitnesstracker.training.internal;

import pl.wsb.fitnesstracker.training.api.Training;
import pl.wsb.fitnesstracker.training.api.TrainingDTO;


public class TrainingMapper {

    TrainingDTO toDto(Training training) {
        return new TrainingDTO(
                training.getUser(),
                training.getStartTime(),
                training.getEndTime(),
                training.getActivityType(),
                training.getDistance(),
                training.getAverageSpeed()
        );
    }

    Training toEntity(TrainingDTO trainingDTO) {
        return new Training(
                trainingDTO.getUser(),
                trainingDTO.getStartTime(),
                trainingDTO.getEndTime(),
                trainingDTO.getActivityType(),
                trainingDTO.getDistance(),
                trainingDTO.getAverageSpeed()
        );
    }
}
