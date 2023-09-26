package Week04_02;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Repair {
    private JFrame frame;
    private Map<String, JCheckBox> checkBoxes;
    private JTextArea resultArea;

    private static final Map<String, Integer> PRICE_LIST = new HashMap<>();

    static {
        PRICE_LIST.put("엔진 오일 변환", 45000);
        PRICE_LIST.put("자동 변속기 오일 교환", 80000);
        PRICE_LIST.put("에어컨 필터 교환", 30000);
        PRICE_LIST.put("타이어 교환", 100000);
    }

    public Repair() {
        frame = new JFrame("자동차 정비 애플리케이션");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        checkBoxes = new HashMap<>();
        for (String repair : PRICE_LIST.keySet()) {
            JCheckBox checkBox = new JCheckBox(repair);
            checkBoxes.put(repair, checkBox);
            panel.add(checkBox);
        }

        JButton calculateButton = new JButton("가격 계산");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTotal();
            }
        });

        resultArea = new JTextArea(5, 20);
        resultArea.setEditable(false);

        panel.add(calculateButton);
        panel.add(resultArea);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    private void calculateTotal() {
        int totalCost = 0;
        StringBuilder resultText = new StringBuilder("선택한 수리 항목:\n");

        for (String repair : checkBoxes.keySet()) {
            JCheckBox checkBox = checkBoxes.get(repair);
            if (checkBox.isSelected()) {
                resultText.append(repair).append(" (").append(PRICE_LIST.get(repair)).append("원)\n");
                totalCost += PRICE_LIST.get(repair);
            }
        }

        resultText.append("총 가격: ").append(totalCost).append("원");

        resultArea.setText(resultText.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Repair();
            }
        });
    }
}
