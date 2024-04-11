package GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CrackCalculator extends Application {

    Label passLenghtlabel = new Label("Password Lenght: ");
    TextField passLength = new TextField();

    RadioButton numbersRadioBtn = new RadioButton("Numbers");
    RadioButton LowercaseRadioBtn = new RadioButton("Lowercase letters");
    RadioButton UppercaseRadioBtn = new RadioButton("Uppercase letters and underscores (_)");
    RadioButton specialCharRadioBtn = new RadioButton("Include special chars (*, . % &)");

    Button calculateTimeButton = new Button("Calculate time to crack");
    Label estematedTimeLabel = new Label("Estimated time: ");

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Password crack time calculator");

        HBox hbox1 = new HBox(new Label(), passLenghtlabel, passLength);
        VBox vbox1 = new VBox(new Label(), numbersRadioBtn, LowercaseRadioBtn, UppercaseRadioBtn, specialCharRadioBtn);
        HBox hbox2 = new HBox(new Label(), calculateTimeButton, estematedTimeLabel);

        // set vbox padding
        vbox1.setMargin(specialCharRadioBtn, new Insets(0, 0, 10, 0));
        hbox2.setMargin(estematedTimeLabel, new Insets(0, 0, 0, 10));
        hbox1.setAlignment(Pos.BASELINE_LEFT);
        hbox2.setAlignment(Pos.BASELINE_LEFT);
        // vbox2.setMargin(yourPassword, new Insets(0, 0, 10, 0));
        // vbox2.setMargin(passStrength, new Insets(0, 0, 10, 0));

        // Create an HBox and add the VBoxes to it
        VBox vbox = new VBox(hbox1, vbox1, hbox2);
        vbox.setPadding(new Insets(10));

        // Create a Scene with the HBox as the root node
        Scene scene = new Scene(vbox, 400, 200);

        stage.setScene(scene);
        stage.show();

    }

    public String passwordStrength() {
        int passLength = Integer.parseInt(this.passLength.getText());
        boolean includeNumbers = this.numbersRadioBtn.isSelected();
        boolean includeLowercase = this.LowercaseRadioBtn.isSelected();
        boolean includeUppercase = this.UppercaseRadioBtn.isSelected();
        boolean includeSpecialChars = this.specialCharRadioBtn.isSelected();
    
        // Logic to determine password strength
        if (passLength >= 8 && (includeNumbers || includeLowercase || includeUppercase || includeSpecialChars)) {
            return "Strong";

        } else if (passLength >= 6 && (includeNumbers || includeLowercase || includeUppercase)) {
            return "Medium";

        } else {
            return "Weak";
            
        }
    }
    

}
