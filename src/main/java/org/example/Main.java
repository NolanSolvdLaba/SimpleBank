package org.example;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

public class Main {
    static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) throws IOException {
        logger.info("Starting the application");

        //Specifying where the file will be written to
        //Creating a string to add to the file
        File email = new File("src/data/interOfficeEmail.txt");
        String emailContent = "Hello, I would like to transfer a customer's money to my personal account.";


        logger.info("Attempting to write string content to .txt file");
        try {
            //writing the file
            FileUtils.write(email, emailContent, Charset.defaultCharset());

            logger.info("File has been successfully written");
        } catch (IOException e){
            logger.error("This file could not be written: " + e);
        }

        //Reading the number of unique words in SimpleBankMissionStatement.txt
        logger.info("Attempting to read the unique words in interOfficeEmail.txt");

        //the file we are reading
        File missionStatement = new File("src/data/SimpleBankMissionStatement.txt");

        try {
            //converting file content to string
            String missionStatementContent = FileUtils.readFileToString(missionStatement, "UTF-8");

            //normalizing the string
            String normalizedStatement = missionStatementContent.toLowerCase().replace("[^a-z\\s]", "");

            //normalized statement broken into words
            String[] words = StringUtils.split(normalizedStatement);

            //using stream to find unique words
            //count() method returns long, not int
            long uniqueWordCount = Arrays.stream(words).distinct().count();

            //returning the number of unique words
            System.out.println("Number of unique words: " + uniqueWordCount);
            logger.info("Number of unique words successfully determined");
        } catch (IOException e) {
            logger.error("The following error occurred: " + e);
        }

        logger.info("Exiting the application");
    }
}