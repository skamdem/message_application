package dev.skamdem.handlingformsubmission;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

/**
 * Uses the @DynamoDbBean annotation that's required
 * for the enhanced client.
 * data members in this class map to the columns
 * in the DynamoDB Greeting table.
 * */
@DynamoDbBean
public class GreetingItems {
    private String id;
    private String name;
    private String message;
    private String title;

    public GreetingItems() {
    }

    public String getId() {
        return this.id;
    }

    @DynamoDbPartitionKey
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage(){
        return this.message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
