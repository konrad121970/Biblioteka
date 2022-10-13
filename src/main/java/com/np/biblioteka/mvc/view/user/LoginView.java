package com.np.biblioteka.mvc.view.user;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogBuilder;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogButton;
import com.np.biblioteka.Display;
import com.np.biblioteka.mvc.view.View;
import org.w3c.dom.Text;

import java.util.Collections;

public class LoginView extends View {

    @Override
    public void render() {
        Display display = getDisplay();
        MultiWindowTextGUI gui = display.getGui();
        BasicWindow window = new BasicWindow();
        window.setHints(Collections.singletonList(Window.Hint.CENTERED));


        Panel container = new Panel(new LinearLayout());
        container.setPreferredSize(new TerminalSize(50, 20));
        container.setLayoutData(
                LinearLayout.createLayoutData(
                    LinearLayout.Alignment.Beginning,
                    LinearLayout.GrowPolicy.None
                )
            );

        LayoutData centered = LinearLayout.createLayoutData(
                LinearLayout.Alignment.Center
        );

        Panel header = new Panel(new LinearLayout().setSpacing(2));
        header.setLayoutData(centered);
        String logo = Display.generateAsciiArt("Biblioteka");
        header.addComponent(new Label(logo).setForegroundColor(TextColor.ANSI.BLUE));

        Panel form = new Panel(new LinearLayout().setSpacing(1));
        form.setLayoutData(centered);

        Panel usernameInput = new Panel();
        usernameInput.addComponent(new Label("Nazwa użytkownika:"));
        TextBox usernameBox = new TextBox(new TerminalSize(30, 1));
        usernameInput.addComponent(usernameBox);
        form.addComponent(usernameInput);

        Panel passwordInput = new Panel();
        passwordInput.addComponent(new Label("Hasło:"));
        TextBox passwordBox = new TextBox(new TerminalSize(30, 1));
        passwordInput.addComponent(passwordBox);
        form.addComponent(passwordInput);

        Button submitButton = new Button("Zaloguj się", () -> {
            String username = usernameBox.getText();
            String password = passwordBox.getText();

            System.out.println(username);
            System.out.println(password);

            if(username.isEmpty() || password.isEmpty()) {
                new MessageDialogBuilder()
                        .setTitle("Wystąpił błąd")
                        .setText("Uzupełnij wszystkie pola formularza!")
                        .addButton(MessageDialogButton.OK)
                        .build()
                        .showDialog(gui);
            }
        });
        form.addComponent(submitButton);

        container.addComponent(header);
        container.addComponent(form);

        window.setComponent(container.withBorder(Borders.singleLine("Logowanie")));
        gui.addWindowAndWait(window);
    }
}
