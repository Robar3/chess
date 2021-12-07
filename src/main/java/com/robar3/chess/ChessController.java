package com.robar3.chess;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;


public class ChessController extends ChessFigure {


    private String step = "black";
    private Image stepFigure;
    private String stepId = "empty";
    private char[] lastPlace = new char[2];
    protected List<Pane> figure = new ArrayList<>();
    @FXML
    private GridPane oneOne;
//    private Image blackQueen = new Image("../blackQueen.png");
//    private Image whiteQueen = new Image("../../resources/figure/white/whiteQueen.png");
    private String charArrayToString(char[] c) {
        String number = "";
        for (int i = 0; i < c.length; i++) {

            number = number + c[i];
        }
        return number;
    }

    protected static String getCell(Pane pane) {
        String needCell = null;
        List<String> listNeedCell = pane.getStyleClass();
        for (String s :
                listNeedCell) {
            needCell = s;
        }
        return needCell;
    }

    private void deleteBorder() {
        for (Pane tt :
                figure) {
            String deleteBorder = tt.getStyle().replace("-fx-border-color: #05fc0f", "");
            tt.setStyle(deleteBorder);
        }
        figure.clear();
    }
    private boolean isTrueCell(Pane node){
        boolean isTrueCell = false;
        for (Pane tt :
                figure) {
            isTrueCell = tt == node;
            if (isTrueCell == true) break;
        }
        return isTrueCell;
    }

    /**
     * Ход поднятой фигурой или ставим нашу фигуру на вражескую
     * @param now текущий цвет
     * @param then вражеский цвет
     * @param id название фигуры
     * @param imageView картинка фигуры
     * @param node текущая клетка
     */
    private void step(String now, String then, String id, ImageView imageView, Pane node) {
        char[] place = getCell(node).toCharArray();
        /**
         * Поднимаем фигуру
         */
        if (stepId.equals("empty")) {
            if (!id.equals("empty")) {
                if (id.startsWith(now)) {
                    lastPlace = place;
                    switch (id.substring(1)){
                        case ("Rook"):rook(node, figure, then);break;
                        case ("Pawn"):pawn(node, figure, then);break;
                        case ("Bishop"):bishop(node, figure, then);break;
                        case ("Queen"):queen(node, figure, then);break;
                        case ("Knight"):knight(node, figure, then);break;
                        case ("King"):king(node, figure, then);break;
                    }


                    stepId = id;
                    stepFigure = imageView.getImage();
                    imageView.setImage(null);
                    node.setId("empty");
                }
            }
        }
        /**
         * Ставим нашу фигуру на вражескую
         */
        else {
            if (id.startsWith(then)&&isTrueCell(node)) {

                if (stepId.substring(1).equals("Pawn")){
                    if (step.equals("black")&&getCell(node).startsWith("7")){
//                        imageView.setImage(blackQueen);
                        stepId="bQueen";
                    }
                    if (step.equals("white")&&getCell(node).startsWith("0")){
//                        imageView.setImage(blackQueen);
                        stepId="wQueen";
                    }

                }
                if (node.getId().substring(1).equals("King")){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Итог");
                    alert.setHeaderText("Итог");
                    if (now.equals("b")){
                        alert.setContentText("Черные победили!");
                    }else alert.setContentText("Белые победили!");
                    alert.showAndWait();
                    Platform.exit();
                }
                imageView.setImage(stepFigure);
                node.setId(stepId);
                stepId = "empty";
                if (step.equals("black")) {
                    step = "white";
                } else step = "black";
                deleteBorder();
            }
        }
    }

    @FXML
    protected void motion(MouseEvent actionEvent) {

        //Текущая нода
        Pane node = (Pane) actionEvent.getSource();
        /**
         * Вытаскиваем айдишник ноды
         */
        char[] place = getCell(node).toCharArray();


        String id = node.getId();
        ImageView imageView = null;
        List<Node> nodeList = node.getChildren();
        for (Node st : nodeList) {
            imageView = (ImageView) st;
        }

        /**
         * Если кликаем на пустое поле
         */
        if (id.equals("empty")) {
            /**
             * Если мы до этого подняли фигуру
             */
            if (stepId != "empty" && isTrueCell(node)) {
                if (stepId.substring(1).equals("Pawn")){
                    if (step.equals("black")&&getCell(node).startsWith("7")){
//                        imageView.setImage(blackQueen);
                        stepId="bQueen";
                    }
                    if (step.equals("white")&&getCell(node).startsWith("0")){
//                        imageView.setImage(blackQueen);
                        stepId="wQueen";
                    }

                }
                imageView.setImage(stepFigure);
                node.setId(stepId);
                stepFigure = null;
                stepId = "empty";
                if (charArrayToString(place).equals(charArrayToString(lastPlace))) {
                    deleteBorder();
                    return;
                }
                if (step.equals("black")) {
                    step = "white";
                } else step = "black";
                deleteBorder();

            }

            /**
             * Если на поле есть фигура - либо поднимаем нашу, либо ставим нашу на вражскую(то есть съедаем)
             */
        } else {
            if (step.equals("black")) {
                step("b", "w", id, imageView, node);
            } else {
                step("w", "b", id, imageView, node);
            }
        }
    }
}
