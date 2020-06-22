package mosha.kartosha.Timetable.view;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import mosha.kartosha.Timetable.util.SettlementUtil;
import mosha.kartosha.Timetable.controller.YandexController;
import mosha.kartosha.Timetable.entity.station.info.Settlement;
import mosha.kartosha.Timetable.entity.timetable.info.IntervalSegments;
import mosha.kartosha.Timetable.entity.timetable.info.Results;
import mosha.kartosha.Timetable.entity.timetable.info.Segment;
import mosha.kartosha.Timetable.entity.timetable.info.Thread;

import java.util.ArrayList;
import java.util.List;


public class MainView extends Application {
    public static final List<Settlement> SETTLEMENTS = SettlementUtil.establishSettlement(YandexController.getAllCountries());
    public static String transportType = "any";

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Yandex.Timetable");
        Image image = new Image("https://avatars.mds.yandex.net/get-yablogs/38241/V1HAAXMtg/orig");
        stage.getIcons().add(image);
        stage.setResizable(false);
        //stage.centerOnScreen();

        Text greetingText = new Text();
        greetingText.setText("Расписание пригородного и междугородного транспорта");
        greetingText.setFont(new Font((20)));
        greetingText.setY(80.0);
        greetingText.setX(260.0);
        Pane pane = new Pane();
        pane.getChildren().add(greetingText);

        createButtons(pane);

        ObservableList<Settlement> settlementObservableList
                = FXCollections.observableArrayList(reg -> new Observable[]{});
        SETTLEMENTS.forEach(settlement -> {
            settlementObservableList.add(settlement);
        });
        ObservableList<Segment> segmentObservableList = FXCollections.observableArrayList();
        ObservableList<IntervalSegments> intervalSegmentsObservableList = FXCollections.observableArrayList();

        ComboBox<Settlement> from = new ComboBox<>();

        from.setItems(settlementObservableList);
        from.setLayoutX(250);
        from.setLayoutY(180);

        Text fromText = new Text();
        fromText.setText("Откуда:");
        fromText.setFont(new Font((20)));
        fromText.setX(250.0);
        fromText.setY(170);
        pane.getChildren().addAll(from, fromText);

        ComboBox<Settlement> to = new ComboBox<>();
        to.setItems(settlementObservableList);
        to.setLayoutX(250);
        to.setLayoutY(250);

        Text toText = new Text();
        toText.setText("Куда:");
        toText.setFont(new Font((20)));
        toText.setX(250);
        toText.setY(240);
        pane.getChildren().addAll(to, toText);


        Button search = new Button("Поиск");
        search.setLayoutX(500);
        search.setLayoutY(320);
        search.setScaleX(1.5);
        search.setScaleY(1.5);
        search.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (!from.getValue().equals(null) && (!to.getValue().equals(null))) {
                    List<Results> results = new ArrayList<>();
                    try {
                        results.add(YandexController.getTimeTables(from.getValue().getCodes().getYandex_code(),
                                to.getValue().getCodes().getYandex_code()));
                    } catch (Exception e) {
                        System.out.println("Ошибка с поселением " + from.getValue().getTitle() + " " + to.getValue().getTitle());
                    }

                    segmentObservableList.clear();
                    intervalSegmentsObservableList.clear();
                    TableView<Segment> segmentTableView = new TableView<>();
                    segmentTableView.setLayoutX(10);
                    segmentTableView.setLayoutY(500);
                    TableView<IntervalSegments> intervalSegmentsTableView = new TableView<>();
                    intervalSegmentsTableView.setLayoutX(500);
                    intervalSegmentsTableView.setLayoutY(500);
                    for (Results res : results) {
                        if (!res.getSegments().isEmpty()) {
                            for (Segment seg : res.getSegments()) {
                                if (!seg.getThread().getTransportType().equals(transportType)) {
                                    segmentObservableList.add(seg);
                                }
                            }
                        }
                        if (!res.getIntervalSegments().isEmpty()) {
                            for (IntervalSegments intervalSegments : res.getIntervalSegments()) {
                                if (!intervalSegments.getThread().getTransportType().equals(transportType)) {
                                    intervalSegmentsObservableList.add(intervalSegments);
                                }
                            }
                        }
                    }
                    segmentTableView.setItems(segmentObservableList);
                    intervalSegmentsTableView.setItems(intervalSegmentsObservableList);

                    TableColumn<Segment, String> departure = new TableColumn<>("Время отправления");
                    departure.setCellValueFactory(new PropertyValueFactory<Segment, String>("departure"));

                    TableColumn<Segment, Long> duration = new TableColumn<>("Длительность поездки, ч");
                    duration.setCellValueFactory(new PropertyValueFactory<Segment, Long>("duration"));

                    TableColumn<Segment, String> startDate = new TableColumn<>("Дата отправления");
                    startDate.setCellValueFactory(new PropertyValueFactory<Segment, String>("start_date"));

                    TableColumn<Segment, String> arrival = new TableColumn<>("Время прибытия");
                    arrival.setCellValueFactory(new PropertyValueFactory<Segment, String>("arrival"));

                    TableColumn<Segment, Thread> thread = new TableColumn<>("Транспорт");
                    thread.setCellValueFactory(new PropertyValueFactory<Segment, Thread>("thread"));


                    TableColumn<IntervalSegments, String> departurePlatformIntervalColumn = new TableColumn<>("Номер платформы Отправления");
                    departurePlatformIntervalColumn.setCellValueFactory(new PropertyValueFactory<IntervalSegments, String>("departure_platform"));

                    TableColumn<IntervalSegments, Long> durationIntervalColumn = new TableColumn<>("Длительность поездки, ч");
                    durationIntervalColumn.setCellValueFactory(new PropertyValueFactory<IntervalSegments, Long>("duration"));

                    TableColumn<IntervalSegments, String> arrivalPlatformIntervalColumn = new TableColumn<>("Номер платформы Прибытия");
                    arrivalPlatformIntervalColumn.setCellValueFactory(new PropertyValueFactory<IntervalSegments, String>("arrival_platform"));

                    TableColumn<IntervalSegments, String> startDateIntervalColumn = new TableColumn<>("Дата отправления");
                    startDateIntervalColumn.setCellValueFactory(new PropertyValueFactory<IntervalSegments, String>("start_date"));

                    TableColumn<IntervalSegments, Thread> threadIntervalColumn = new TableColumn<>("Транспорт");
                    threadIntervalColumn.setCellValueFactory(new PropertyValueFactory<IntervalSegments, Thread>("thread"));


                    segmentTableView.getColumns().setAll(departure, duration, startDate, arrival, thread);
                    intervalSegmentsTableView.getColumns().setAll(departurePlatformIntervalColumn, durationIntervalColumn,
                            arrivalPlatformIntervalColumn, startDateIntervalColumn, threadIntervalColumn);
                    segmentTableView.setMinWidth(300);
                    intervalSegmentsTableView.setMinWidth(300);
                    if (intervalSegmentsObservableList.isEmpty()) {
                        segmentTableView.setLayoutX(300);
                        segmentTableView.setLayoutY(500);
                        segmentTableView.setMinWidth(500);
                        pane.getChildren().add(segmentTableView);
                    } else {
                        pane.getChildren().addAll(segmentTableView, intervalSegmentsTableView);
                    }
                }
            }
        });
        pane.getChildren().add(search);

        Scene scene = new Scene(pane, 1100, 1000, Color.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }

    private void createButtons(Pane pane) {
        Button any = new Button("Любой");
        any.setLayoutX(282);
        any.setLayoutY(100);
        any.setScaleX(1.5);
        any.setScaleY(1.5);
        any.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                transportType = "any";
            }
        });

        Button plane = new Button("Самолёт");
        plane.setLayoutX(370);
        plane.setLayoutY(100);
        plane.setScaleX(1.5);
        plane.setScaleY(1.5);
        plane.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                transportType = "plane";
            }
        });

        Button train = new Button("Поезд");
        train.setLayoutX(465);
        train.setLayoutY(100);
        train.setScaleX(1.5);
        train.setScaleY(1.5);
        train.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                transportType = "train";
            }
        });

        Button suburban = new Button("Электричка");
        suburban.setLayoutX(552);
        suburban.setLayoutY(100);
        suburban.setScaleX(1.5);
        suburban.setScaleY(1.5);
        suburban.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                transportType = "suburban";
            }
        });

        Button bus = new Button("Автобус");
        bus.setLayoutX(670);
        bus.setLayoutY(100);
        bus.setScaleX(1.5);
        bus.setScaleY(1.5);
        bus.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                transportType = "bus";
            }
        });
        pane.getChildren().addAll(any, plane, bus, train, suburban);
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
