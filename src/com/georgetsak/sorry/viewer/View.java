package com.georgetsak.sorry.viewer;

import com.georgetsak.sorry.controller.Controller;
import com.georgetsak.sorry.model.Board;
import com.georgetsak.sorry.model.Color;
import com.georgetsak.sorry.model.Pawn;
import com.georgetsak.sorry.model.card.*;
import com.georgetsak.sorry.model.square.Square;
import com.georgetsak.sorry.model.square.SquareMultiplePawns;
import com.georgetsak.sorry.model.square.SquarePlain;

import javax.imageio.ImageIO;
import javax.naming.ldap.Control;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class View {
    private JFrame frame;
    private Controller controller;

    private Image cardBack = null;
    private Image cardSorry = null;
    private Image card1 = null;
    private Image card2 = null;
    private Image card3 = null;
    private Image card4 = null;
    private Image card5 = null;
    private Image card7 = null;
    private Image card8 = null;
    private Image card10 = null;
    private Image card11 = null;
    private Image card12 = null;
    private Image redPawnImage = null;
    private Image yellowPawnImage = null;

    private JLayeredPane gamePanel;
    private JPanel optionsPanel;

    private JButton newGameButton;
    private JButton exitButton;
    private JButton pickCardButton;
    private JButton forfeitMoveButton;
    private JButton saveGameButton;
    private JButton loadGameButton;
    private JButton[] boardSquaresButtons;
    private JLabel playerPlayingLabel;
    private JLabel cardsLeftLabel;
    private JLabel currentCardLabel;

    private JLabel pawnRed1Label;
    private JLabel pawnRed2Label;
    private JLabel pawnYellow1Label;
    private JLabel pawnYellow2Label;

    private int origin = -1;

    /**
     * <b>Constructor</b> constructs the View and initializes and displays the window
     * <b>Postcondition</b> a View is created and window along with its inner main components like panels are initialized and displayed
     */
    public View(Controller controller){
        this.controller = controller;

        frame = new JFrame("Sorry! 4186");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(1024, 605);
        frame.setLocationRelativeTo(null);

        Image imageBackground = null;
        Image imageBoard = null;
        Image imageLogo = null;

        try {
            imageBackground = ImageIO.read(new File("src/assets/background.jpg"));
            imageBoard = ImageIO.read(new File("src/assets/board/board.jpg"));
            imageLogo = ImageIO.read(new File("src/assets/board/sorry_logo.png"));
            cardBack = ImageIO.read(new File("src/assets/card/card_back.png"));
            cardSorry = ImageIO.read(new File("src/assets/card/card_sorry.png"));
            card1 = ImageIO.read(new File("src/assets/card/card1.png"));
            card2 = ImageIO.read(new File("src/assets/card/card2.png"));
            card3 = ImageIO.read(new File("src/assets/card/card3.png"));
            card4 = ImageIO.read(new File("src/assets/card/card4.png"));
            card5 = ImageIO.read(new File("src/assets/card/card5.png"));
            card7 = ImageIO.read(new File("src/assets/card/card7.png"));
            card8 = ImageIO.read(new File("src/assets/card/card8.png"));
            card10 = ImageIO.read(new File("src/assets/card/card10.png"));
            card11 = ImageIO.read(new File("src/assets/card/card11.png"));
            card12 = ImageIO.read(new File("src/assets/card/card12.png"));
            redPawnImage = ImageIO.read(new File("src/assets/pawn/red_pawn.png"));
            yellowPawnImage = ImageIO.read(new File("src/assets/pawn/yellow_pawn.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Could not load images. Exiting...");
            System.exit(-1);

        }

        JLabel background = new JLabel(new ImageIcon(imageBackground));
        JLabel board = new JLabel(new ImageIcon(imageBoard));
        JLabel sorryLogo = new JLabel(new ImageIcon(imageLogo));

        JPanel mainPanel = new JPanel(null);
        gamePanel = new JLayeredPane();
        optionsPanel = new JPanel(null);
        optionsPanel.setOpaque(false);

        gamePanel.setBounds(0, 0, 576, 576);
        optionsPanel.setBounds(577, 0, 448, 576);

        sorryLogo.setBounds(188, 188, 200, 200);

        initBoardSquares();

        gamePanel.add(sorryLogo);
        gamePanel.add(board);
        background.setBounds(0, 0, 1024, 576);
        board.setBounds(0, 0, 576, 576);

        initGui();

        mainPanel.add(optionsPanel);
        mainPanel.add(gamePanel);
        mainPanel.add(background);

        frame.add(mainPanel);
        frame.setVisible(true);

    }

    /**
     * <b>Transformer(mutative)</b> Initializes and displays the gui buttons except for the square ones
     * <b>Postcondition</b> all buttons but square buttons are initialized and displayed into the gui
     */
    public void initGui(){

        newGameButton = new JButton("New Game");
        exitButton = new JButton("Exit Game");
        pickCardButton = new JButton();
        forfeitMoveButton = new JButton("Fold Card");
        saveGameButton = new JButton("Save Game");
        loadGameButton = new JButton("Load Game");
        playerPlayingLabel = new JLabel();
        cardsLeftLabel = new JLabel();
        currentCardLabel = new JLabel();
        updateGUI(Color.NONE, null, 0);

        newGameButton.setBounds(10, 10, 90, 30);
        saveGameButton.setBounds(110, 10, 90, 30);
        loadGameButton.setBounds(210, 10, 90, 30);
        exitButton.setBounds(340, 10, 90, 30);

        pickCardButton.setIcon(new ImageIcon(cardBack.getScaledInstance(129, 198, Image.SCALE_SMOOTH)));
        pickCardButton.setBounds(85, 120, 129, 198);

        currentCardLabel.setBounds(235, 120, 129, 198);

        forfeitMoveButton.setBounds(85, 330, 279, 35);
        forfeitMoveButton.setFont(new Font("Tahoma", Font.PLAIN, 25));

        cardsLeftLabel.setBounds(85, 400, 200, 30);
        cardsLeftLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));

        playerPlayingLabel.setBounds(85, 440, 200, 30);
        playerPlayingLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));

        newGameButton.addActionListener(new View.newGameButtonListener());
        exitButton.addActionListener(new View.exitButtonListener());
        pickCardButton.addActionListener(new View.pickCardButtonListener());
        forfeitMoveButton.addActionListener(new View.forfeitMoveButtonListener());
        saveGameButton.addActionListener(new View.saveGameButtonListener());
        loadGameButton.addActionListener(new View.loadGameButtonListener());

        optionsPanel.add(newGameButton);
        optionsPanel.add(exitButton);
        optionsPanel.add(pickCardButton);
        optionsPanel.add(forfeitMoveButton);
        optionsPanel.add(saveGameButton);
        optionsPanel.add(loadGameButton);
        optionsPanel.add(playerPlayingLabel);
        optionsPanel.add(cardsLeftLabel);
        optionsPanel.add(currentCardLabel);
    }

    /**
     * <b>Transformer(mutative)</b> Initializes and displays the square buttons
     * <b>Postcondition</b> square buttons are initialized and displayed into gui
     */
    public void initBoardSquares(){
        Image squareImage = null;
        Image squareSliderStartRedImage = null;
        Image squareSliderMidRedImage = null;
        Image squareSliderEndRedImage = null;
        Image squareSliderStartBlueImage = null;
        Image squareSliderMidBlueImage = null;
        Image squareSliderEndBlueImage = null;
        Image squareSliderStartYellowImage = null;
        Image squareSliderMidYellowImage = null;
        Image squareSliderEndYellowImage = null;
        Image squareSliderStartGreenImage = null;
        Image squareSliderMidGreenImage = null;
        Image squareSliderEndGreenImage = null;
        Image squareRed = null;
        Image squareYellow = null;
        Image squareHomeRed = null;
        Image squareHomeYellow = null;
        Image squareStartRed = null;
        Image squareStartYellow = null;

        try {
            squareImage = ImageIO.read(new File("src/assets/board/square.png"));
            squareSliderStartRedImage = ImageIO.read(new File("src/assets/board/slider_start_red.png"));
            squareSliderMidRedImage = ImageIO.read(new File("src/assets/board/slider_mid_red.png"));
            squareSliderEndRedImage = ImageIO.read(new File("src/assets/board/slider_end_red.png"));
            squareSliderStartBlueImage = ImageIO.read(new File("src/assets/board/slider_start_blue.png"));
            squareSliderMidBlueImage = ImageIO.read(new File("src/assets/board/slider_mid_blue.png"));
            squareSliderEndBlueImage = ImageIO.read(new File("src/assets/board/slider_end_blue.png"));
            squareSliderStartYellowImage = ImageIO.read(new File("src/assets/board/slider_start_yellow.png"));
            squareSliderMidYellowImage = ImageIO.read(new File("src/assets/board/slider_mid_yellow.png"));
            squareSliderEndYellowImage = ImageIO.read(new File("src/assets/board/slider_end_yellow.png"));
            squareSliderStartGreenImage = ImageIO.read(new File("src/assets/board/slider_start_green.png"));
            squareSliderMidGreenImage = ImageIO.read(new File("src/assets/board/slider_mid_green.png"));
            squareSliderEndGreenImage = ImageIO.read(new File("src/assets/board/slider_end_green.png"));
            squareRed = ImageIO.read(new File("src/assets/board/square_red.png"));
            squareYellow = ImageIO.read(new File("src/assets/board/square_yellow.png"));
            squareHomeRed = ImageIO.read(new File("src/assets/board/home_red.png"));
            squareHomeYellow = ImageIO.read(new File("src/assets/board/home_yellow.png"));
            squareStartRed = ImageIO.read(new File("src/assets/board/start_red.png"));
            squareStartYellow = ImageIO.read(new File("src/assets/board/start_yellow.png"));
        }catch (Exception e){
            System.err.println("Could not load one or more of the square images. Aborting...");
            e.printStackTrace();
            System.exit(-1);
        }

        pawnRed1Label = new JLabel(new ImageIcon(redPawnImage));
        pawnRed2Label = new JLabel(new ImageIcon(redPawnImage));
        pawnYellow1Label = new JLabel(new ImageIcon(yellowPawnImage));
        pawnYellow2Label = new JLabel(new ImageIcon(yellowPawnImage));

        gamePanel.add(pawnRed1Label, new Integer(1));
        gamePanel.add(pawnRed2Label, new Integer(1));
        gamePanel.add(pawnYellow1Label, new Integer(1));
        gamePanel.add(pawnYellow2Label, new Integer(1));

        boardSquaresButtons = new JButton[74];

        for(int i = 0; i <= 73; i++){
            boardSquaresButtons[i] = new JButton();
            boardSquaresButtons[i].setBounds(getBoundsForSquareId(i));
        }

        if(false) {//set true to show the IDs of the buttons instead of their icons
            for (int i = 0; i <= 73; i++) {
                if(boardSquaresButtons[i] == null)continue;
                boardSquaresButtons[i].setText(String.valueOf(i));
                boardSquaresButtons[i].setBorder(null);
                boardSquaresButtons[i].setFont(new Font("Tahoma", Font.PLAIN, 14));
                boardSquaresButtons[i].addActionListener(new View.squareButtonListener());
                gamePanel.add(boardSquaresButtons[i], new Integer(0));
            }
        }else{
            for(int i = 0; i <= 73; i++){
                if(boardSquaresButtons[i] == null)continue;

                switch (i){
                    case 57:
                    case 5:
                        boardSquaresButtons[i].setIcon(new ImageIcon(squareSliderStartGreenImage));
                        break;
                    case 12:
                    case 20:
                        boardSquaresButtons[i].setIcon(new ImageIcon(squareSliderStartRedImage));
                        break;
                    case 27:
                    case 35:
                        boardSquaresButtons[i].setIcon(new ImageIcon(squareSliderStartBlueImage));
                        break;
                    case 42:
                    case 50:
                        boardSquaresButtons[i].setIcon(new ImageIcon(squareSliderStartYellowImage));
                        break;
                    case 13:
                    case 14:
                    case 21:
                    case 22:
                    case 23:
                        boardSquaresButtons[i].setIcon(new ImageIcon(squareSliderMidRedImage));
                        break;
                    case 28:
                    case 29:
                    case 36:
                    case 37:
                    case 38:
                        boardSquaresButtons[i].setIcon(new ImageIcon(squareSliderMidBlueImage));
                        break;
                    case 43:
                    case 44:
                    case 51:
                    case 52:
                    case 53:
                        boardSquaresButtons[i].setIcon(new ImageIcon(squareSliderMidYellowImage));
                        break;
                    case 58:
                    case 59:
                    case 6:
                    case 7:
                    case 8:
                        boardSquaresButtons[i].setIcon(new ImageIcon(squareSliderMidGreenImage));
                        break;
                    case 15:
                    case 24:
                        boardSquaresButtons[i].setIcon(new ImageIcon(squareSliderEndRedImage));
                        break;
                    case 30:
                    case 39:
                        boardSquaresButtons[i].setIcon(new ImageIcon(squareSliderEndBlueImage));
                        break;
                    case 45:
                    case 54:
                        boardSquaresButtons[i].setIcon(new ImageIcon(squareSliderEndYellowImage));
                        break;
                    case 0:
                    case 9:
                        boardSquaresButtons[i].setIcon(new ImageIcon(squareSliderEndGreenImage));
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                        boardSquaresButtons[i].setIcon(new ImageIcon(squareRed));
                        break;
                    case 68:
                    case 69:
                    case 70:
                    case 71:
                    case 72:
                        boardSquaresButtons[i].setIcon(new ImageIcon(squareYellow));
                        break;
                    case 66:
                        boardSquaresButtons[i].setIcon(new ImageIcon(squareHomeRed));
                        break;
                    case 73:
                        boardSquaresButtons[i].setIcon(new ImageIcon(squareHomeYellow));
                        break;
                    case 60:
                        boardSquaresButtons[i].setIcon(new ImageIcon(squareStartRed));
                        break;
                    case 67:
                        boardSquaresButtons[i].setIcon(new ImageIcon(squareStartYellow));
                        break;
                    default:
                        boardSquaresButtons[i].setIcon(new ImageIcon(squareImage));
                }
                boardSquaresButtons[i].addActionListener(new View.squareButtonListener());
                gamePanel.add(boardSquaresButtons[i], new Integer(0));
            }
        }

    }

    /**
     * Displays a confirm dialog windows with {@code title} title and {@code message} message and returns an integer depending on the user input
     * @param title the title of the dialog window
     * @param message the message of the dialog window
     * @return an int depending on the user input; 1 for yes and 0 for no
     */
    public int displayConfirmDialog(String title, String message){
        return JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION) == 0 ? 1 : 0;
    }

    /**
     * Returns a rectangle that represents the bounds of the square with the same {@code id} id or null if the square is not found.
     * <b>Postcondition</b> A rectangle that represents the bounds of the square with the same {@code id} is returned; null otherwise
     * @param id the id of the square to get the bounds of
     * @return a Rectangle or null if the square is not found
     */
    private Rectangle getBoundsForSquareId(int id){
        if(id >= 11 && id <= 26){
            return new Rectangle(1 + (id-11)*36, 0, 34, 34);
        }

        if(id >= 27 && id <= 40){
            return new Rectangle(541, 36 + (id-27)*36, 34, 34);
        }

        if(id >= 41 && id <= 56){
            return new Rectangle(1 + (56-id)*36, 540, 34, 34);
        }

        if(id >= 0 && id <= 10){
            return new Rectangle(1, (11 - id) * 36, 34, 34);
        }

        if(id >= 57 && id <= 59){
            return new Rectangle(1, (71 - id) * 36, 34, 34);
        }

        if(id == 60){
            return new Rectangle(128 ,36, 68, 68);
        }

        if(id >= 61 && id <= 65){
            return new Rectangle(73, (id - 60) * 36, 34, 34);
        }

        if(id == 66){
            return new Rectangle(57, 216, 68, 68);
        }

        if(id == 67){
            return new Rectangle(379 ,470, 68, 68);
        }

        if(id >= 68 && id <= 72){
            return new Rectangle(469, 360 + (72 - id) * 36, 34, 34);
        }

        if(id == 73){
            return new Rectangle(452, 290, 68, 68);
        }

        return null;
    }

    /**
     * <b>Transformer(mutative)</b> Sets the origin variable to -1.
     * <b>Postcondition</b> the origin variable is set to -1
     */
    public void resetOrigin(){
        origin = -1;
    }

    /**
     * <b>Transformer(mutative)<b/>Changes the location of the {@code pawn} pawn's label to a the {@code squareId} square.
     * Id is the label's id. 0 for first pawn, 1 for second.
     * <b>Precondition</b> {@code squareId} is a valid square id (0-73) including 0 and 73, {@code pawn} is not null and
     * id is 0 or 1.
     * <b>Postcondition</b> the location of the {@code pawn} pawn's label is changed
     * @param squareId the id of the square to move the pawn's label to
     * @param pawn the pawn label's to be moved
     * @param id whether the label to be moved represents the first or second pawn
     */
    public void renderPawnOnSquare(int squareId, Pawn pawn, int id){
        JLabel pawnLabel;

        if(pawn.getColor() == Color.RED)pawnLabel = id == 0 ? pawnRed1Label : pawnRed2Label;
        else pawnLabel = id == 0 ? pawnYellow1Label : pawnYellow2Label;

        Rectangle rectangle = getBoundsForSquareId(squareId);
        if(rectangle == null)return;

        if(squareId == 60 || squareId == 66 || squareId == 67 || squareId == 73){
            if(id == 0){
                rectangle = new Rectangle(rectangle.x - 15, rectangle.y, rectangle.width, rectangle.height);
            }else{
                rectangle = new Rectangle(rectangle.x + 15, rectangle.y, rectangle.width, rectangle.height);
            }
        }

        pawnLabel.setBounds(rectangle);

    }

    /**
     * Updates the 'Player playing' label, the Current Card image (label) and the 'Cards left' label
     * <b>Postcondition</b> the 'Player playing' label, the Current Card image (label) and the 'Cards left' label are updated
     * @param playingColor the color of the player that is playing
     * @param currentCard the card to display
     * @param cardsLeft cards left
     */
    public void updateGUI(Color playingColor, Card currentCard, int cardsLeft){
        playerPlayingLabel.setText("Player playing: " + playingColor.name());
        cardsLeftLabel.setText("Cards left: " + cardsLeft);

        if(currentCard == null){
          currentCardLabel.setIcon(null);
        } else if(currentCard instanceof CardOne){
            currentCardLabel.setIcon(new ImageIcon(card1.getScaledInstance(129, 198, Image.SCALE_SMOOTH)));
        }else if(currentCard instanceof CardTwo){
            currentCardLabel.setIcon(new ImageIcon(card2.getScaledInstance(129, 198, Image.SCALE_SMOOTH)));
        }else if(currentCard instanceof CardThree){
            currentCardLabel.setIcon(new ImageIcon(card3.getScaledInstance(129, 198, Image.SCALE_SMOOTH)));
        }else if(currentCard instanceof CardFour){
            currentCardLabel.setIcon(new ImageIcon(card4.getScaledInstance(129, 198, Image.SCALE_SMOOTH)));
        }else if(currentCard instanceof CardFive){
            currentCardLabel.setIcon(new ImageIcon(card5.getScaledInstance(129, 198, Image.SCALE_SMOOTH)));
        }else if(currentCard instanceof CardSeven){
            currentCardLabel.setIcon(new ImageIcon(card7.getScaledInstance(129, 198, Image.SCALE_SMOOTH)));
        }else if(currentCard instanceof CardEight){
            currentCardLabel.setIcon(new ImageIcon(card8.getScaledInstance(129, 198, Image.SCALE_SMOOTH)));
        }else if(currentCard instanceof CardTen){
            currentCardLabel.setIcon(new ImageIcon(card10.getScaledInstance(129, 198, Image.SCALE_SMOOTH)));
        }else if(currentCard instanceof CardEleven){
            currentCardLabel.setIcon(new ImageIcon(card11.getScaledInstance(129, 198, Image.SCALE_SMOOTH)));
        }else if(currentCard instanceof CardTwelve){
            currentCardLabel.setIcon(new ImageIcon(card12.getScaledInstance(129, 198, Image.SCALE_SMOOTH)));
        }else{
            currentCardLabel.setIcon(new ImageIcon(cardSorry.getScaledInstance(129, 198, Image.SCALE_SMOOTH)));
        }

    }

    /**
     * Destroys the current frame
     * <b>Postcondition</b> the current frame is destroyed
     */
    public void destroy(){
        frame.setVisible(false);
        frame.dispose();
        frame = null;
    }

    private class squareButtonListener implements ActionListener{
        /**
         * <b>transformer(mutative)
         * </b>:doing some action after a square button has been pressed<br />
         * <p><b>Postcondition:</b> doing some action after a square button has been pressed</p>
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = 0;

            for (int i = 0; i <= 73; i++) {
                if(e.getSource() == boardSquaresButtons[i]){
                    id = i;
                    break;
                }
            }

            if(origin != -1 && id != origin){
                controller.movePawnOnSquareTo(origin, id);
                origin = -1;
            }else{
                origin = id;
            }

        }

    }

    private class newGameButtonListener implements ActionListener{
        /**
         * <b>transformer(mutative)
         * </b>:doing some action after the new game button has been pressed<br />
         * <p><b>Postcondition:</b> doing some action after the new game button has been pressed</p>
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if(displayConfirmDialog("New Game", "Are you sure you want to start a new game?") == 1){
                destroy();
                new Controller();
            }
        }

    }

    private class saveGameButtonListener implements ActionListener{
        /**
         * <b>transformer(mutative)
         * </b>:doing some action after the save game button has been pressed<br />
         * <p><b>Postcondition:</b> doing some action after the save game button has been pressed</p>
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            fileChooser.setDialogTitle("Select save location");
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Sorry! save file", "sorry");
            fileChooser.setFileFilter(filter);

            if(fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                File saveFile = fileChooser.getSelectedFile();
                if (saveFile != null) {
                    controller.save(saveFile);
                }
            }
        }
    }

    private class loadGameButtonListener implements ActionListener{
        /**
         * <b>transformer(mutative)
         * </b>:doing some action after the load game button has been pressed<br />
         * <p><b>Postcondition:</b> doing some action after the load game button has been pressed</p>
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setDialogTitle("Select save file to load");
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Sorry! save file", "sorry");
            fileChooser.setFileFilter(filter);

            if(fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                File saveFile = fileChooser.getSelectedFile();
                if (saveFile != null) {
                    System.out.println("NORMAL");
                    controller.load(saveFile);
                }
            }
        }

    }

    private class exitButtonListener implements ActionListener{
        /**
         * <b>transformer(mutative)
         * </b>:doing some action after the exit button has been pressed<br />
         * <p><b>Postcondition:</b> doing some action after the exit button has been pressed</p>
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if(displayConfirmDialog("Exit", "Are you sure you want to exit the game?") == 1){
                System.exit(0);
            }
        }

    }

    private class pickCardButtonListener implements ActionListener{
        /**
         * <b>transformer(mutative)
         * </b>:doing some action after the pick card button has been pressed<br />
         * <p><b>Postcondition:</b> doing some action after the pick card button has been pressed</p>
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if(controller.canPlayerPickCard()){
                controller.pickCard();
            }
        }

    }

    private class forfeitMoveButtonListener implements ActionListener{
        /**
         * <b>transformer(mutative)
         * </b>:doing some action after the forfeit move button has been pressed<br />
         * <p><b>Postcondition:</b> doing some action after the forfeit move button has been pressed</p>
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) {
                controller.fold();
        }

    }

}
