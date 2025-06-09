package pl.wsb.fitnesstracker.training.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import pl.wsb.fitnesstracker.training.internal.ActivityType;
import pl.wsb.fitnesstracker.user.api.User;

import java.util.Date;


public record TrainingDto(
    Long id,
    User user,
    Date startTime,
    Date endTime,
    ActivityType activityType,
    double distance,
    double averageSpeed){}

