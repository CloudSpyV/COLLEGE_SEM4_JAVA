import java.awt.*;
import java.awt.event.*;

public class ButtonEventDemo extends Frame implements ActionListener {
    private TextField tfCount;
    private Button btnCount;
    private int count = 0;

    public ButtonEventDemo() {
        setLayout(new FlowLayout());

        add(new Label("Counter"));
        tfCount = new TextField("0", 10);
        tfCount.setEditable(false);
        add(tfCount);

        btnCount = new Button("Count");
        add(btnCount);
        btnCount.addActionListener(this);

        setTitle("ButtonEvent Demo");
        setSize(250, 100);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ButtonEventDemo();
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        ++count;
        tfCount.setText(count + "");
    }
}
