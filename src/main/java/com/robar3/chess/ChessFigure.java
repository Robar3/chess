package com.robar3.chess;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.List;

import static com.robar3.chess.ChessController.getCell;


public class ChessFigure {
    @FXML
    private GridPane oneOne;

    protected void rook(Pane node, List<Pane> figure, String then) {
        char[] thithCharPane = getCell(node).toCharArray();
        //строка
        int x = thithCharPane[0] - '0';
        //колонка
        int y = thithCharPane[1] - '0';
        figure.add(node);

        for (int i = x - 1; 0 <= i; i--) {
            Pane pane = (Pane) oneOne.getChildren().get(i * 8 + y);
            if (pane.getId().startsWith(then)) {
                pane.setStyle(pane.getStyle() + "-fx-border-color: #05fc0f");
                figure.add(pane);
                break;
            }
            if (pane.getId().equals("empty")) {
                pane.setStyle(pane.getStyle() + "-fx-border-color: #05fc0f");
                figure.add(pane);
            } else break;
        }
        for (int i = y - 1; 0 <= i; i--) {

            Pane pane = (Pane) oneOne.getChildren().get(x * 8 + i);
            if (pane.getId().startsWith(then)) {
                pane.setStyle(pane.getStyle() + "-fx-border-color: #05fc0f");
                figure.add(pane);
                break;
            }
            if (pane.getId().equals("empty")) {
                pane.setStyle(pane.getStyle() + "-fx-border-color: #05fc0f");
                figure.add(pane);
            } else break;
        }

        for (int i = x + 1; 7 >= i; i++) {
            Pane pane = (Pane) oneOne.getChildren().get(i * 8 + y);
            if (pane.getId().startsWith(then)) {
                pane.setStyle(pane.getStyle() + "-fx-border-color: #05fc0f");
                figure.add(pane);
                break;
            }
            if (pane.getId().equals("empty")) {
                pane.setStyle(pane.getStyle() + "-fx-border-color: #05fc0f");
                figure.add(pane);
            } else break;
        }
        for (int i = y + 1; 7 >= i; i++) {
            Pane pane = (Pane) oneOne.getChildren().get(x * 8 + i);
            if (pane.getId().startsWith(then)) {
                pane.setStyle(pane.getStyle() + "-fx-border-color: #05fc0f");
                figure.add(pane);
                break;
            }
            if (pane.getId().equals("empty")) {
                pane.setStyle(pane.getStyle() + "-fx-border-color: #05fc0f");
                figure.add(pane);
            } else break;
        }
    }

    protected void pawn(Pane node, List<Pane> figure, String then) {
        figure.add(node);
        char[] thithCharPane = getCell(node).toCharArray();
        int x = thithCharPane[0] - '0';
        int y = thithCharPane[1] - '0';
        Pane pane;
        if (node.getId().startsWith("w")) {
            if (x == 6) {
                pane = (Pane) oneOne.getChildren().get((x - 1) * 8 + y);
                if (pane.getId().equals("empty")) {
                    pane = (Pane) oneOne.getChildren().get((x - 2) * 8 + y);
                    if (pane.getId().equals("empty")) {
                    pane.setStyle(pane.getStyle() + "-fx-border-color: #05fc0f");
                    figure.add(pane);}
                }
            }
            pane = (Pane) oneOne.getChildren().get((x - 1) * 8 + y);
            if (pane.getId().equals("empty")) {
                pane.setStyle(pane.getStyle() + "-fx-border-color: #05fc0f");
                figure.add(pane);
            }
            pane = (Pane) oneOne.getChildren().get((x - 1) * 8 + y-1);
            if (pane.getId().startsWith(then)) {
                pane.setStyle(pane.getStyle() + "-fx-border-color: #05fc0f");
                figure.add(pane);
            }
            pane = (Pane) oneOne.getChildren().get((x - 1) * 8 + y+1);
            if (pane.getId().startsWith(then)) {
                pane.setStyle(pane.getStyle() + "-fx-border-color: #05fc0f");
                figure.add(pane);
            }

        }
        if (node.getId().startsWith("b")) {

            if (x == 1) {
                pane = (Pane) oneOne.getChildren().get((x + 1) * 8 + y);
                if (pane.getId().equals("empty")) {
                    pane = (Pane) oneOne.getChildren().get((x + 2) * 8 + y);
                    pane.setStyle(pane.getStyle() + "-fx-border-color: #05fc0f");
                    figure.add(pane);
                }
            }
            pane = (Pane) oneOne.getChildren().get((x + 1) * 8 + y);

            if (pane.getId().equals("empty")) {
                pane.setStyle(pane.getStyle() + "-fx-border-color: #05fc0f");
                figure.add(pane);
            }
            pane = (Pane) oneOne.getChildren().get((x +1 ) * 8 + y-1);
            if (pane.getId().startsWith(then)) {
                pane.setStyle(pane.getStyle() + "-fx-border-color: #05fc0f");
                figure.add(pane);
            }
            pane = (Pane) oneOne.getChildren().get((x + 1) * 8 + y+1);
            if (pane.getId().startsWith(then)) {
                pane.setStyle(pane.getStyle() + "-fx-border-color: #05fc0f");
                figure.add(pane);
            }
        }
    }

    protected void bishop(Pane node, List<Pane> figure, String then) {
        char[] thithCharPane = getCell(node).toCharArray();
        int x = thithCharPane[0] - '0';
        int y = thithCharPane[1] - '0';
        figure.add(node);
        int j = y;
        //горизонталь вверх влево
        for (int i = x - 1; i >= 0 && j > 0; i--) {
            j--;
            Pane pane = (Pane) oneOne.getChildren().get(i * 8 + j);
            if (pane.getId().startsWith(then)) {
                pane.setStyle(pane.getStyle() + "-fx-border-color: #05fc0f");
                figure.add(pane);
                break;
            }
            if (pane.getId().equals("empty")) {
                pane.setStyle(pane.getStyle() + "-fx-border-color: #05fc0f");
                figure.add(pane);

            } else break;
        }
        j = y;
        //горизонталь вниз лево

        for (int i = x + 1; i <= 7 && j > 0; i++) {
            j--;
            Pane pane = (Pane) oneOne.getChildren().get(i * 8 + j);
            if (pane.getId().startsWith(then)) {
                pane.setStyle(pane.getStyle() + "-fx-border-color: #05fc0f");
                figure.add(pane);
                break;
            }
            if (pane.getId().equals("empty")) {
                pane.setStyle(pane.getStyle() + "-fx-border-color: #05fc0f");
                figure.add(pane);

            } else break;
        }
        j = y;
        //горизонталь вниз вправо

        for (int i = x + 1; i <= 7 && j < 7; i++) {
            j++;
            Pane pane = (Pane) oneOne.getChildren().get(i * 8 + j);
            if (pane.getId().startsWith(then)) {
                pane.setStyle(pane.getStyle() + "-fx-border-color: #05fc0f");
                figure.add(pane);
                break;
            }
            if (pane.getId().equals("empty")) {
                pane.setStyle(pane.getStyle() + "-fx-border-color: #05fc0f");
                figure.add(pane);

            } else break;
        }
        j = y;
        //горизонталь право верх

        for (int i = x - 1; i >= 0 && j < 7; i--) {
            j++;
            Pane pane = (Pane) oneOne.getChildren().get(i * 8 + j);
            if (pane.getId().startsWith(then)) {
                pane.setStyle(pane.getStyle() + "-fx-border-color: #05fc0f");
                figure.add(pane);
                break;
            }
            if (pane.getId().equals("empty")) {
                pane.setStyle(pane.getStyle() + "-fx-border-color: #05fc0f");
                figure.add(pane);

            } else break;
        }
    }


    protected void queen(Pane node, List<Pane> figure, String then) {
        bishop(node, figure, then);
        rook(node, figure, then);
    }

    private void checkKnight(Pane pane, List<Pane> figure, String then) {
        if (pane.getId().startsWith(then)) {
            pane.setStyle(pane.getStyle() + "-fx-border-color: #05fc0f");
            figure.add(pane);
        }
        if (pane.getId().equals("empty")) {
            pane.setStyle(pane.getStyle() + "-fx-border-color: #05fc0f");
            figure.add(pane);
        }
    }

    protected void knight(Pane node, List<Pane> figure, String then) {
        figure.add(node);
        char[] thithCharPane = getCell(node).toCharArray();
        int x = thithCharPane[0] - '0';
        int y = thithCharPane[1] - '0';

        Pane pane;
        int i;
        int j;
        //Право
        i = x - 1;
        j = y + 2;
        if (i >= 0 && i <= 7 && j >= 0 && j <= 7) {
            pane = (Pane) oneOne.getChildren().get(i * 8 + j);
            checkKnight(pane, figure, then);
        }
        i = x + 1;
        j = y + 2;
        if (i >= 0 && i <= 7 && j >= 0 && j <= 7) {
            pane = (Pane) oneOne.getChildren().get(i * 8 + j);
            checkKnight(pane, figure, then);
        }
        //Верх
        i = x - 2;
        j = y - 1;
        if (i >= 0 && i <= 7 && j >= 0 && j <= 7) {
            pane = (Pane) oneOne.getChildren().get(i * 8 + j);
            checkKnight(pane, figure, then);
        }
        i = x - 2;
        j = y + 1;
        if (i >= 0 && i <= 7 && j >= 0 && j <= 7) {
            pane = (Pane) oneOne.getChildren().get(i * 8 + j);
            checkKnight(pane, figure, then);
        }
        //Лево
        i = x - 1;
        j = y - 2;
        if (i >= 0 && i <= 7 && j >= 0 && j <= 7) {
            pane = (Pane) oneOne.getChildren().get(i * 8 + j);
            checkKnight(pane, figure, then);
        }
        i = x + 1;
        j = y - 2;
        if (i >= 0 && i <= 7 && j >= 0 && j <= 7) {
            pane = (Pane) oneOne.getChildren().get(i * 8 + j);
            checkKnight(pane, figure, then);
        }
        //Низ
        i = x + 2;
        j = y - 1;
        if (i >= 0 && i <= 7 && j >= 0 && j <= 7) {
            pane = (Pane) oneOne.getChildren().get(i * 8 + j);
            checkKnight(pane, figure, then);
        }
        i = x + 2;
        j = y + 1;
        if (i >= 0 && i <= 7 && j >= 0 && j <= 7) {
            pane = (Pane) oneOne.getChildren().get(i * 8 + j);
            checkKnight(pane, figure, then);
        }
    }

    protected void king(Pane node, List<Pane> figure, String then) {
        figure.add(node);

        char[] thithCharPane = getCell(node).toCharArray();
        int x = thithCharPane[0] - '0';
        int y = thithCharPane[1] - '0';

        //Право
        for (int i = 0; i < 3; i++) {
            if (x + i-1 >= 0 && x + i-1 <= 7 && y + 1 >= 0 && y + 1 <= 7) {
                Pane pane = (Pane) oneOne.getChildren().get((x + i-1) * 8 + (y + 1));
                checkKnight(pane, figure, then);
            }
        }
        //Центр
        for (int i = 0; i < 3; i++) {
            if (x + i-1 >= 0 && x + i-1 <= 7 && y >= 0 && y <= 7) {
                Pane pane = (Pane) oneOne.getChildren().get((x + i-1) * 8 + y);
                checkKnight(pane, figure, then);
            }
        }
        //Лево
        for (int i = 0; i < 3; i++) {
            if (x + i-1 >= 0 && x + i-1 <= 7 && y - 1 >= 0 && y - 1 <= 7) {
                Pane pane = (Pane) oneOne.getChildren().get((x + i-1) * 8 + (y - 1));
                checkKnight(pane, figure, then);
            }
        }
    }
}

