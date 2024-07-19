package dev.skamdem.handlingformsubmission;

import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.SnsException;
import org.springframework.stereotype.Component;

/**
 * Sends a text message by using Amazon SNS
 * when a new item is added to the DynamoDB table
 *
 * specify a valid mobile number for the phoneNumber variable
 * */
@Component("PublishTextSMS")
public class PublishTextSMS {
    public void sendMessage(String id) {
        Region region = Region.US_EAST_1;
        SnsClient snsClient = SnsClient.builder()
                .region(region)
                .credentialsProvider(EnvironmentVariableCredentialsProvider.create())
                .build();

        String message = "A new item with ID value "+ id +" was added to the DynamoDB table";
        String phoneNumber = "<Enter a valid mobile number>"; // Replace with a mobile phone number.

        try {
            PublishRequest request = PublishRequest.builder()
                    .message(message)
                    .phoneNumber(phoneNumber)
                    .build();

            snsClient.publish(request);

        } catch (SnsException e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
    }
}
