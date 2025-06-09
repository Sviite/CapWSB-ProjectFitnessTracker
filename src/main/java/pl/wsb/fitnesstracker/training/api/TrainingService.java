package pl.wsb.fitnesstracker.training.api;

public interface TrainingService {
    Training createTraining(TrainingShortDto trainingShortDto);
    Training updateTraining(Long id, TrainingShortDto trainingShortDto);
}
