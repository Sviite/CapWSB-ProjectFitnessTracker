package pl.wsb.fitnesstracker.training.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.fitnesstracker.training.api.Training;
import pl.wsb.fitnesstracker.user.api.User;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

interface TrainingRepository extends JpaRepository<Training, Long> {
    default Optional<Training> findByTrainingByDate(Date date) {
        return findAll().stream()
                .filter(training -> Objects.equals(training.getEndTime(), date))
                .findFirst();
    }}
