package pl.wsb.fitnesstracker.training.internal;

import org.springframework.stereotype.Component;
import pl.wsb.fitnesstracker.training.api.Training;
import pl.wsb.fitnesstracker.training.api.TrainingDto;

@Component
public class TrainingMapper {

    TrainingDto toDto(Training training) {
        return new TrainingDto(
                training.getId(),
                training.getUser(),
                training.getStartTime(),
                training.getEndTime(),
                training.getActivityType(),
                training.getDistance(),
                training.getAverageSpeed()
        );
    }

    Training toEntity(TrainingDto trainingDTO) {
        return new Training(
                trainingDTO.user(),
                trainingDTO.startTime(),
                trainingDTO.endTime(),
                trainingDTO.activityType(),
                trainingDTO.distance(),
                trainingDTO.averageSpeed()
        );
    }
}
