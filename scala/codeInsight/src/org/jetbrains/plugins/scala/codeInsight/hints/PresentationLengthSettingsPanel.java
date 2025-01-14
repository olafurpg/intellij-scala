package org.jetbrains.plugins.scala.codeInsight.hints;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static org.jetbrains.plugins.scala.codeInsight.ScalaCodeInsightSettings.MAX_PRESENTATION_LENGTH;
import static org.jetbrains.plugins.scala.codeInsight.ScalaCodeInsightSettings.MIN_PRESENTATION_LENGTH;

public final class PresentationLengthSettingsPanel {

    private JPanel panel;
    private SpinnerNumberModel presentationLengthModel;
    private JSpinner presentationLengthSpinner;
    private final Supplier<Integer> presentationLengthGetter;

    public PresentationLengthSettingsPanel(Supplier<Integer> presentationLengthGetter, Consumer<Integer> presentationLengthSetter) {
        this.presentationLengthGetter = presentationLengthGetter;
        presentationLengthModel = new SpinnerNumberModel();
        $$$setupUI$$$();
        presentationLengthModel.setMinimum(MIN_PRESENTATION_LENGTH);
        presentationLengthModel.setMaximum(MAX_PRESENTATION_LENGTH);
        presentationLengthModel.setStepSize(1);
        reset();
        presentationLengthModel.addChangeListener((e) -> presentationLengthSetter.accept(presentationLengthModel.getNumber().intValue()));
    }

    public void reset() {
        presentationLengthModel.setValue(presentationLengthGetter.get());
    }

    private void createUIComponents() {
        presentationLengthSpinner = new JSpinner(presentationLengthModel);
        ((JSpinner.DefaultEditor) presentationLengthSpinner.getEditor()).getTextField().setColumns(3);
    }

    public JPanel getPanel() {
        return panel;
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        panel = new JPanel();
        panel.setLayout(new GridLayoutManager(2, 4, new Insets(0, 0, 0, 0), -1, -1));
        final JLabel label1 = new JLabel();
        label1.setText("Limit hint length to");
        panel.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        panel.add(presentationLengthSpinner, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("characters");
        panel.add(label2, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel.add(spacer1, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        panel.add(spacer2, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        label1.setLabelFor(presentationLengthSpinner);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel;
    }

}
