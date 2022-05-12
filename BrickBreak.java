//Breakout Game in javafx
//start of code
//imported files
import javafx.scene.layout.VBox;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
//main code starting
public class BrickBreak extends Application {
    //scenes
    Scene scene, app, applied, another, hardpart;
    @Override

    public void start(Stage stage) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        //image and group for "Normal" game
        Image ana = new Image("https://mir-s3-cdn-cf.behance.net/project_modules/fs/c221c957092339.59c8dfa58d6d7.jpg");
        ImageView xoo = new ImageView(ana);
        Group sort = new Group(xoo);
        applied = new Scene(sort);
        //end
        //image and group for "Hard" game
        Image ana1 = new Image("https://c4.wallpaperflare.com/wallpaper/477/913/211/spooky-castle-black-castle-art-print-wallpaper-preview.jpg");
        ImageView xoo2 = new ImageView(ana1);
        xoo2.setFitWidth(1700);
        xoo2.setFitHeight(1000);
        Group sort2 = new Group(xoo2);
        hardpart = new Scene(sort2);
        //end
        //GridPane for allignment
        GridPane o = new GridPane();
        o.setHgap(10);
        o.setVgap(10);
        o.setPadding(new Insets(10, 10, 10, 10));

        //ball and paddle formation
        //for "Normal Level"
        Circle ball = new Circle(5, Color.AQUA);
        ball.relocate(300, 200);
        Rectangle paddle = new Rectangle(100, 10, Color.ANTIQUEWHITE);
        paddle.relocate(275, 390);
        sort.getChildren().addAll(paddle, ball);
        //end
        //For "Hard Level"
        Circle ball2 = new Circle(5, Color.BLUE);
        ball2.relocate(300, 200);
        Rectangle paddle2 = new Rectangle(70, 4, Color.RED);
        paddle2.relocate(275, 390);
        sort2.getChildren().addAll(paddle2, ball2);
        //end

        //Bricks Formation for Hard and Normal Level
        Bricks bricks = new Bricks();
        Bricks2 bricks2 = new Bricks2();
        TimeLine timeLine = new TimeLine();
        TimeLine2 timeLine2 = new TimeLine2();

        Canvas canvas = new Canvas(1970, 1970);
        sort.getChildren().add(canvas);
        sort2.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        //Audio file for background Music
        File f = new File("Awake.wav");
        AudioInputStream m = AudioSystem.getAudioInputStream(f);
        Clip c = AudioSystem.getClip();
        c.open(m);
        c.start();
        //image for main menu
        Image a = new Image("https://preview.redd.it/s5rikyxsdd951.png?width=1756&format=png&auto=webp&s=887be1e32eb3649312b531a57acfe447ff49c3c3");
        ImageView x = new ImageView(a);
        InnerShadow is = new InnerShadow();
        is.setOffsetX(1.0f);
        is.setOffsetY(1.0f);
        //menu page
        Text scenetitle = new Text("\tBREAK OUT GAME");
        scenetitle.setEffect(is);
        scenetitle.setFill(Color.WHITE);
        scenetitle.setFont(Font.font("Bodoni MT Condensed", FontWeight.BOLD, 50));
        //Buttons
        Button btn = new Button("Play Game");
        btn.setPrefSize(400, 25);
        Button btn1 = new Button("Help");
        btn1.setPrefSize(400, 25);
        Button btn2 = new Button("Exit");
        btn2.setPrefSize(400, 25);
        Button about = new Button("About");
        about.setPrefSize(400, 25);
        Button Normal = new Button("Normal");
        Normal.setPrefSize(300, 25);
        Button Hard = new Button("Hard");
        Hard.setPrefSize(300, 25);
        //fonts
        Font font = Font.font("Bodoni MT Condensed", FontWeight.THIN, 15);

        btn.setFont(font);
        btn1.setFont(font);
        btn2.setFont(font);
        Normal.setFont(font);
        Hard.setFont(font);
        about.setFont(font);
        //Texts
        final Text sope1 = new Text();
        sope1.setFont(Font.font("Bernard MT Condensed", FontWeight.BOLD, 40));
        sope1.setFill(Color.ANTIQUEWHITE);
        final Text sope = new Text();
        sope.setFont(Font.font("Bernard MT Condensed", FontWeight.BOLD, 30));
        sope.setFill(Color.ANTIQUEWHITE);
        Text roll = new Text();
        Text About = new Text();
        Text names = new Text();
        //Button actions
        //play game button
        btn.setOnAction(e -> {
            Image marine = new Image("https://media.istockphoto.com/photos/schwarzenberg-tomb-in-full-moon-night-trebon-czech-republic-picture-id1071783344?k=20&m=1071783344&s=612x612&w=0&h=L52qh0qlD74w4LexPQ3WmkRAHE7pjDMl5RhIAcZb5UA=");
            ImageView xoop = new ImageView(marine);
            roll.setText("Level");
            roll.setFont(Font.font("Bernard MT Condensed", FontWeight.BOLD, 30));
            roll.setFill(Color.ANTIQUEWHITE);
            VBox layout1 = new VBox(20);
            layout1.getChildren().addAll(roll, Normal, Hard);
            layout1.setLayoutX(150);
            layout1.setLayoutY(120);
            Group exo = new Group(xoop, layout1);
            another = new Scene(exo, 600, 400);

            Stage mope = new Stage();
            mope.setTitle("Levels of BreakOut");
            mope.setResizable(false);
            mope.setScene(another);
            mope.show();

        });
        //about button
        about.setOnAction(e -> {
            Image yahoo = new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTQm1VqUZaPL-eUXJf5tlj2-u5n9Wyx1AQx6g&usqp=CAU");
            ImageView xooop = new ImageView(yahoo);
            xooop.setFitWidth(900);
            xooop.setFitHeight(500);
            About.setText("\t\t\tCOLABORATIONS");
            About.setFont(Font.font("Bernard MT Condensed", FontWeight.BOLD, 20));
            About.setFill(Color.ANTIQUEWHITE);
            names.setText("\nFrom the \"UNIVERSITY OF ENGINEERING AND TECHNOLOGY, TAXILA\" this game has been made\nby the collaboration of:\n \n1.Sowaiba Arshad\n2.Hamna Gul\n3.Khadija Muneeb Khan\n4.Aamna Javed\n5.Hamna Nadeem\n6.Kinza Waqas");
            names.setFont(Font.font("Bernard MT Condensed", FontWeight.BOLD, 15));
            names.setFill(Color.ANTIQUEWHITE);
            VBox layout1 = new VBox(20);
            layout1.getChildren().addAll(About, names);
            layout1.setLayoutX(100);
            layout1.setLayoutY(120);
            Group exo = new Group(xooop, layout1);
            another = new Scene(exo, 700, 400);

            Stage mope = new Stage();
            mope.setTitle("About");
            mope.setResizable(false);
            mope.setScene(another);
            mope.show();

        });
        //in playgame for Normal level
        Normal.setOnAction(new EventHandler < ActionEvent > () {
            public void handle(ActionEvent e) {
                stage.setScene(applied);
            }
        });

        applied.setOnKeyPressed(new EventHandler < KeyEvent > () {
            @Override
            public void handle(KeyEvent coding) {
                switch (coding.getCode()) {
                case LEFT:
                    System.out.println("Left");
                    paddle.relocate(paddle.getLayoutX() - 20, paddle.getLayoutY());
                    if (paddle.getLayoutX() <= 0) {
                        paddle.relocate(0, paddle.getLayoutY());
                    }

                    break;
                case RIGHT:
                    System.out.println("Right");
                    paddle.relocate(paddle.getLayoutX() + 20, paddle.getLayoutY());
                    if (paddle.getLayoutX() >= 700) {
                        paddle.relocate(1000, paddle.getLayoutY());
                    }

                    break;
                case UP:
                    System.out.println("UP");
                    paddle.relocate(paddle.getLayoutX(), paddle.getLayoutY() - 10);

                    break;
                case DOWN:
                    System.out.println("Down");
                    paddle.relocate(paddle.getLayoutX() - 10, paddle.getLayoutY() + 10);

                    break;
                case ENTER:

                    ball.setFill(Color.BLANCHEDALMOND);
                    paddle.setFill(Color.YELLOWGREEN);
                    timeLine.Animation(ball, paddle, bricks.Create_bricks(sort), sort);

                    break;

                }

            }
        });
        //in playgame for Hard level
        Hard.setOnAction(new EventHandler < ActionEvent > () {
            public void handle(ActionEvent e) {
                stage.setScene(hardpart);
            }
        });
        hardpart.setOnKeyPressed(new EventHandler < KeyEvent > () {
            @Override
            public void handle(KeyEvent coding2) {
                switch (coding2.getCode()) {
                case LEFT:
                    System.out.println("Left");
                    paddle2.relocate(paddle2.getLayoutX() - 20, paddle2.getLayoutY());
                    if (paddle2.getLayoutX() <= 0) {
                        paddle2.relocate(0, paddle2.getLayoutY());
                    }

                    break;
                case RIGHT:
                    System.out.println("Right");
                    paddle2.relocate(paddle2.getLayoutX() + 20, paddle2.getLayoutY());
                    if (paddle2.getLayoutX() >= 700) {
                        paddle2.relocate(1000, paddle2.getLayoutY());
                    }

                    break;
                case UP:
                    System.out.println("UP");
                    paddle2.relocate(paddle2.getLayoutX(), paddle2.getLayoutY() - 10);

                    break;
                case DOWN:
                    System.out.println("Down");
                    paddle2.relocate(paddle2.getLayoutX() - 10, paddle2.getLayoutY() + 10);

                    break;
                case ENTER:

                    ball2.setFill(Color.CYAN);
                    paddle2.setFill(Color.HOTPINK);
                    timeLine2.Animation(ball2, paddle2, bricks2.Create_bricks(sort2), sort2);

                    break;

                }

            }
        });
        //help button
        btn1.setOnAction(new EventHandler < ActionEvent > () {
            public void handle(ActionEvent e) {

                Image alpha = new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTMYJL54VRQK511vjpA8H8T5Wn3vWv61svDqA&usqp=CAU");
                ImageView xop = new ImageView(alpha);
                xop.setFitWidth(700);
                xop.setFitHeight(600);
                Stage pop = new Stage();
                Label code = new Label("HELP: ");
                code.setFont(Font.font("Bernard MT Condensed", FontWeight.BOLD, 20));
                code.setTextFill(Color.ANTIQUEWHITE);
                Label n = new Label("1.Using a single ball, the player must knock down as many bricks as possible by using the walls \n    and/or the paddle below to hit the ball against the bricks and eliminate them. \n2.If the player's paddle misses the ball's rebound, they will lose a turn. \n3.The player has three turns to try to clear two screens of bricks.\n4. Please press \"ENTER\" to play game.\n4.Do remeber that you have only 3 lives to play.");
                n.setFont(Font.font("Bernard MT Condensed", FontWeight.NORMAL, 15));
                n.setTextFill(Color.ANTIQUEWHITE);
                VBox layout2 = new VBox(20);
                layout2.getChildren().addAll(code, n);
                layout2.setLayoutX(100);
                layout2.setLayoutY(120);
                Group nope = new Group(xop, layout2);
                app = new Scene(nope, 700, 500);
                pop.setScene(app);
                stage.setTitle("Help");
                stage.setResizable(false);
                pop.show();

            }
        });
        //exit button
        btn2.setOnAction(new EventHandler < ActionEvent > () {
            public void handle(ActionEvent e) {
                System.exit(0);
            }
        });

        o.add(sope1, 0, 0);
        o.add(sope, 1, 3);
        o.add(scenetitle, 50, 0);
        o.add(btn, 50, 5);
        o.add(btn1, 50, 9);
        o.add(about, 50, 13);
        o.add(btn2, 50, 17);
        o.setLayoutX(20);
        o.setLayoutY(150);
        stage.setTitle("BreakOutGame");

        Group n = new Group(x, o);
        scene = new Scene(n, 600, 600);

        stage.setScene(scene);
        stage.setScene(scene);

        stage.setResizable(true);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}
//timeline class for Normal Game
class TimeLine {
    int score;
    int CurrentLives = 3;
    int get_score() {
        return score;
    }

    void Animation(Circle ball, Rectangle paddle, ArrayList < Rectangle > allBricks, Group root) {

        boolean Gameover = false;
        Text current_score = new Text();
        Text lives = new Text();
        Text wining = new Text();
        current_score.setFill(Color.WHITE);
        current_score.setFont(Font.font("Times New Roman", 15));
        current_score.setX(10);
        current_score.setY(10);
        lives.setFill(Color.WHITE);
        lives.setFont(Font.font("Times New Roman", 15));
        lives.setX(100);
        lives.setY(10);
        root.getChildren().addAll(current_score, lives);
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20),
            new EventHandler < ActionEvent > () {

                double dx = 4;
                double dy = 2;

                public void ball_droped(Circle ball, Rectangle paddle) {
                    ball.relocate(300, 270);

                    paddle.setLayoutX(270);
                    paddle.setLayoutY(370);

                }
                @Override
                public void handle(ActionEvent t) {
                    //moving ball 
                    ball.setLayoutX(ball.getLayoutX() + dx);
                    ball.setLayoutY(ball.getLayoutY() + dy);

                    boolean leftWall = ball.getLayoutX() <= 0;
                    boolean topWall = ball.getLayoutY() < 35;
                    boolean rightWall = ball.getLayoutX() >= 1400;
                    boolean bottomWall = ball.getLayoutY() >= 700;

                    // If the top wall has been touched, the ball reverses direction.
                    if (topWall) {
                        dy = dy * -1;
                    }

                    // If the left or right wall has been touched, the ball reverses direction.
                    if (leftWall || rightWall) {
                        dx = dx * -1;
                    }
                    //lives if bottomn wall touched and after 3 lives end of game
                    if (bottomWall) {

                        ball_droped(ball, paddle);
                        CurrentLives--;

                        if (CurrentLives < 1) {
                            CurrentLives = 0;
                            root.getChildren().removeAll(ball, paddle);

                            lives.setText("Lives : " + CurrentLives);
                            Text text = new Text("GAME OVER");
                            text.setFill(Color.WHITE);
                            DropShadow ds = new DropShadow();
                            ds.setOffsetY(3.0f);
                            ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
                            text.setEffect(ds);
                            text.setFont(Font.font("Times New Roman", 40));
                            text.setX(500);
                            text.setY(500);
                            root.getChildren().add(text);
                        }
                    }
                    if (allBricks.isEmpty()) {
                        root.getChildren().removeAll(ball, paddle);

                        wining.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
                        wining.setText("CONGRATULATIONS");
                        root.getChildren().add(wining);
                    }
                    //if ball collides with paddle
                    if (collide(paddle, ball)) {
                        dy = -dy;
                    }

                    //if ball and brick collides, change color of brick and than remove brick

                    Rectangle temp = null;
                    for (Rectangle brick: allBricks) {
                        if (collide(brick, ball)) {
                            if ((ball.getLayoutY() >= brick.getLayoutY() - 4) && (ball.getLayoutY() <= brick.getLayoutY() + 24)) {
                                dx = -1 * dy;
                            }
                            if (brick.getFill().equals(Color.ANTIQUEWHITE)) {
                                score += 1;
                                brick.setFill(Color.GREEN);
                                break;
                            } else if (brick.getFill().equals(Color.GREEN)) {
                                score += 1;
                                brick.setFill(Color.YELLOW);
                                break;
                            } else if (brick.getFill().equals(Color.YELLOW)) {
                                score += 1;
                                brick.setFill(Color.RED);
                                break;
                            } else if (brick.getFill().equals(Color.RED)) {
                                score += 1;
                                current_score.setText("Score : " + score);
                                root.getChildren().remove(brick);
                                temp = brick;
                                break;
                            }
                        }
                    }
                    if (!(temp == null)) {
                        allBricks.remove(temp);
                        temp = null;;
                    }
                }
                public boolean collide(Rectangle obj, Circle ball) {
                    System.out.println(obj.getBoundsInLocal().intersects(ball.getBoundsInLocal()));
                    if (obj.getBoundsInParent().intersects(ball.getBoundsInParent())) {
                        ball.setLayoutX(ball.getLayoutX() - (dx * 4));
                        ball.setLayoutY(ball.getLayoutY() - (dy * 4));
                        //                                      
                        dx = -dy;

                        return true;
                    } else return false;

                }

            }));
        timeline.setCycleCount(timeline.INDEFINITE);
        timeline.play();
    }
}
//bricks formation
class Bricks {
    public Object setFill;
    ArrayList Create_bricks(Group root) {
        ArrayList < Rectangle > allBricks = new ArrayList < > ();
        for (int x = 1; x < 20; x++) {
            for (int y = 0; y < 10; y++) {
                Rectangle brick = new Rectangle(60, 15);
                brick.setFill(Color.ANTIQUEWHITE);
                brick.setLayoutX(x * 65);
                brick.setLayoutY((20 * y) + 35);
                root.getChildren().add(brick);
                allBricks.add(brick);
            }
        }
        return allBricks;
    }

}
//for hard level
class TimeLine2 {
    int score;
    int CurrentLives = 3;
    int get_score() {
        return score;
    }
    void Animation(Circle ball2, Rectangle paddle2, ArrayList < Rectangle > allBricks, Group root) {
        boolean Gameover = false;
        Text current_score = new Text();
        Text lives = new Text();
        Text wining = new Text();
        lives.setFill(Color.WHITE);
        lives.setFont(Font.font("Times New Roman", 15));
        lives.setX(100);
        lives.setY(10);
        current_score.setFill(Color.WHITE);
        current_score.setFont(Font.font("Times New Roman", 15));
        current_score.setX(10);
        current_score.setY(10);
        root.getChildren().addAll(current_score, lives);
        Timeline timeline2 = new Timeline(new KeyFrame(Duration.millis(20),
            new EventHandler < ActionEvent > () {

                double dx = 4;
                double dy = 2;

                public void ball_droped(Circle ball, Rectangle paddle) {
                    ball.relocate(300, 270);

                    paddle.setLayoutX(270);
                    paddle.setLayoutY(370);

                }

                @Override
                public void handle(ActionEvent t) {
                    //moving ball
                    ball2.setLayoutX(ball2.getLayoutX() + dx);
                    ball2.setLayoutY(ball2.getLayoutY() + dy);

                    boolean leftWall = ball2.getLayoutX() <= 0;
                    boolean topWall = ball2.getLayoutY() < 35;
                    boolean rightWall = ball2.getLayoutX() >= 1400;
                    boolean bottomWall = ball2.getLayoutY() >= 700;

                    // If the top wall has been touched, the ball2 reverses direction.
                    if (topWall) {
                        dy = dy * -1;
                    }

                    // If the left or right wall has been touched, the ball2 reverses direction.
                    if (leftWall || rightWall) {
                        dx = dx * -1;
                    }
                    //lives if bottomn wall touched and after 3 lives end of game
                    if (bottomWall) {

                        ball_droped(ball2, paddle2);
                        CurrentLives--;

                        if (CurrentLives < 1) {
                            CurrentLives = 0;
                            root.getChildren().removeAll(ball2, paddle2);

                            lives.setText("Lives : " + CurrentLives);
                            Text text = new Text("GAME OVER");
                            text.setFill(Color.WHITE);
                            DropShadow ds = new DropShadow();
                            ds.setOffsetY(3.0f);
                            ds.setColor(Color.color(0.6f, 0.5f, 0.4f));
                            text.setEffect(ds);
                            text.setFont(Font.font("Times New Roman", 40));
                            text.setX(500);
                            text.setY(500);
                            root.getChildren().add(text);
                        }
                    }
                    if (allBricks.isEmpty()) {
                        root.getChildren().removeAll(ball2, paddle2);

                        wining.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
                        wining.setText("CONGRATULATIONS");
                        root.getChildren().add(wining);
                    }
                    //if ball2 collides with paddle
                    if (collide(paddle2, ball2)) {
                        dy = -dy;
                    }

                    //if ball and brick collides, change color of brick and than remove brick

                    Rectangle temp = null;
                    for (Rectangle brick: allBricks) {
                        if (collide(brick, ball2)) {
                            if ((ball2.getLayoutY() >= brick.getLayoutY() - 4) && (ball2.getLayoutY() <= brick.getLayoutY() + 24)) {
                                dx = -1 * dy;
                            }
                            if (brick.getFill().equals(Color.CORNSILK)) {
                                score += 1;
                                brick.setFill(Color.GREEN);
                                break;
                            } else if (brick.getFill().equals(Color.GREEN)) {
                                score += 1;
                                brick.setFill(Color.YELLOW);
                                break;
                            } else if (brick.getFill().equals(Color.YELLOW)) {
                                score += 1;
                                brick.setFill(Color.RED);
                                break;
                            } else if (brick.getFill().equals(Color.RED)) {
                                score += 1;
                                current_score.setText("Score : " + score);
                                root.getChildren().remove(brick);
                                temp = brick;
                                break;
                            }
                        }
                    }
                    if (!(temp == null)) {
                        allBricks.remove(temp);
                        temp = null;;
                    }
                }
                public boolean collide(Rectangle obj, Circle ball) {
                    System.out.println(obj.getBoundsInLocal().intersects(ball.getBoundsInLocal()));
                    if (obj.getBoundsInParent().intersects(ball.getBoundsInParent())) {
                        ball.setLayoutX(ball.getLayoutX() - (dx * 4));
                        ball.setLayoutY(ball.getLayoutY() - (dy * 4));
                        //                                      
                        dx = -dy;

                        return true;
                    } else return false;

                }
            }));
        timeline2.setCycleCount(timeline2.INDEFINITE);
        timeline2.play();
    }
}
//brick formation for Hard level
class Bricks2 {
    public Object setFill;
    ArrayList Create_bricks(Group root) {
        Text none = new Text();
        ArrayList < Rectangle > allBricks = new ArrayList < > ();
        for (int x = 1; x < 10; x++) {
            for (int y = 0; y < 15; y++) {
                Rectangle brick = new Rectangle(60, 15);
                brick.setFill(Color.CORNSILK);
                brick.setLayoutX(x * 105);
                brick.setLayoutY((20 * y) + 35);
                root.getChildren().add(brick);
                allBricks.add(brick);
            }
        }
        return allBricks;
    }

}
//end of code