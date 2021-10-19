package constants;

public class Constants {
  public static final String DROP_RESERVATION = "DROP TABLE reservation";
  public static final String DROP_PASSENGER = "DROP TABLE passenger";
  public static final String DROP_ROUTE = "DROP TABLE route";
  public static final String DROP_BUS = "DROP TABLE bus";
  public static final String DROP_BUS_STATUS = "DROP TABLE BUS_STATUS";

  public static final String CREATE_RESERVATION_TABLE = "CREATE TABLE Reservation ( reservation_id NUMBER GENERATED BY DEFAULT AS IDENTITY, cost NUMBER,  " +
          "status VARCHAR(20),reservation_date DATE, departure_date DATE, CONSTRAINT reservation_pk PRIMARY KEY (reservation_id))";

  public static final String CREATE_PASSENGER_TABLE = "CREATE TABLE Passenger (  passenger_id NUMBER GENERATED BY DEFAULT AS IDENTITY, name VARCHAR(20)," +
          " email VARCHAR(20), age NUMBER,  bus_id NUMBER NOT NULL, reservation_id NUMBER NOT NULL, CONSTRAINT passenger_pk PRIMARY KEY (passenger_id), " +
          "CONSTRAINT passenger_bus_fk FOREIGN KEY (bus_id) REFERENCES bus(bus_id), CONSTRAINT reservation_fk FOREIGN KEY (reservation_id) REFERENCES reservation(reservation_id) )";

  public static final String CREATE_ROUTE_TABLE = "CREATE TABLE Route ( route_id NUMBER GENERATED BY DEFAULT AS IDENTITY, bus_id NUMBER NOT NULL, " +
          "arrival_time VARCHAR(10), route_marker VARCHAR(10), CONSTRAINT route_pk PRIMARY KEY (route_id), CONSTRAINT route_bus_fk FOREIGN KEY (bus_id) REFERENCES bus(bus_id))";

  public static final String CREATE_BUS_TABLE = "CREATE TABLE Bus ( bus_id NUMBER GENERATED BY DEFAULT AS IDENTITY, name VARCHAR(10), source VARCHAR(20), " +
          "destination VARCHAR(20), CONSTRAINT bus_pk PRIMARY KEY (bus_id) )";

  public static final String CREATE_BUS_STATUS_TABLE = "CREATE TABLE BUS_STATUS(BUS_STATUS_ID NUMBER GENERATED ALWAYS AS IDENTITY, BUS_ID NUMBER REFERENCES BUS(BUS_ID) NOT NULL, " +
          "BUS_DATE DATE, BOOKED_SEATS NUMBER, AVAILABLE_SEATS NUMBER NOT NULL, WAIT_LISTED_SEATS NUMBER, PRIMARY KEY (BUS_STATUS_ID))";
}
