package com.dnissley.servlets;

import javax.servlet.ServletException;

import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;

public class Application {
  public static void main(String[] args) throws ServletException {
    DeploymentInfo servletBuilder = Servlets.deployment()
      .setClassLoader(Application.class.getClassLoader())
      .setContextPath("/app")
      .setDeploymentName("test.war")
      .addServlet(Servlets.servlet("HelloServlet", HelloServlet.class).addMapping("/hello"));

    DeploymentManager manager = Servlets.defaultContainer().addDeployment(servletBuilder);
    manager.deploy();

    HttpHandler servletHandler = manager.start();

    Undertow server = Undertow.builder()
      .addHttpListener(8080, "localhost")
      .setHandler(servletHandler)
      .build();

    server.start();
  }
}

