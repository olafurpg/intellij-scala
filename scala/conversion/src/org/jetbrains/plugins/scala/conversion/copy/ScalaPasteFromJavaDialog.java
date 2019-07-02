package org.jetbrains.plugins.scala.conversion.copy;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.plugins.scala.conversion.ScalaConversionBundle;
import org.jetbrains.plugins.scala.settings.ScalaProjectSettings;

import javax.swing.*;
import java.awt.*;

/**
 * User: Alexander Podkhalyuzin
 * Date: 30.11.2009
 */
public class ScalaPasteFromJavaDialog extends DialogWrapper {
    private JPanel myPanel;
    private JCheckBox donTShowThisCheckBox;
    private JLabel lable1;
    private JButton buttonOK;
    private ScalaProjectSettings mySettings;

    public ScalaPasteFromJavaDialog(Project project,
                                    ScalaProjectSettings settings,
                                    String message) {
        super(project, true);
        mySettings = settings;
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Convert Code from Java");
        lable1.setText(message);
        init();
    }

    public static boolean showAndGet(String reason, Project project) {
        ScalaProjectSettings projectSettings = ScalaProjectSettings.getInstance(project);
        return projectSettings.isDontShowConversionDialog() ||
                new ScalaPasteFromJavaDialog(
                        project,
                        projectSettings,
                        ScalaConversionBundle.message("scala.copy.from", reason)
                ).showAndGet();
    }

    protected JComponent createCenterPanel() {
        return myPanel;
    }

    public Container getContentPane() {
        return myPanel;
    }

    @NotNull
    protected Action[] createActions() {
        return new Action[]{getOKAction(), getCancelAction()};
    }

    protected void doOKAction() {
        if (donTShowThisCheckBox.isSelected()) {
            mySettings.setDontShowConversionDialog(true);
        }
        super.doOKAction();
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        myPanel = new JPanel();
        myPanel.setLayout(new GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        lable1 = new JLabel();
        lable1.setText("Clipboard content copied from Java file. Do you want to convert it to Scala code?");
        myPanel.add(lable1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        myPanel.add(spacer1, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        donTShowThisCheckBox = new JCheckBox();
        donTShowThisCheckBox.setText("Don't show this dialog next time");
        donTShowThisCheckBox.setMnemonic('D');
        donTShowThisCheckBox.setDisplayedMnemonicIndex(0);
        myPanel.add(donTShowThisCheckBox, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return myPanel;
    }
}
