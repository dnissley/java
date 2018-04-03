package com.dnissley;

import org.apache.log4j.Logger;

class Application {

  private static final Logger LOGGER = Logger.getLogger(Application.class);

  public static void main(String[] args) {
    MessageService messageService = new MessageService();

    String message = messageService.getMessage();
    LOGGER.info("Received message: " + message);
  }
}

