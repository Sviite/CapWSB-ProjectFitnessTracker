package pl.wsb.fitnesstracker.training.api;

import lombok.*;
import pl.wsb.fitnesstracker.training.internal.ActivityType;
import pl.wsb.fitnesstracker.user.api.User;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@ToString
@Data
public class TrainingDTO {
            final User user;
            final Date startTime;
            final Date endTime;
            final ActivityType activityType;
            final double distance;
            final double averageSpeed;
}
