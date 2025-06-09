package pl.wsb.fitnesstracker.training.api;

public interface TrainingService {
    Training createTraining(TrainingDTO trainingDTO);
    Training updateTraining(TrainingDTO trainingDTO, long id);
}
