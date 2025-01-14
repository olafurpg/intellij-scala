package org.jetbrains.plugins.scala.codeInsight;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.util.Getter;
import com.intellij.openapi.util.Setter;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;

@State(
        name = "ScalaCodeInsightSettings",
        storages = {@Storage("scala_code_insight_settings.xml")}
)
public class ScalaCodeInsightSettings implements PersistentStateComponent<ScalaCodeInsightSettings> {

    public static final boolean SHOW_TYPE_HINTS_DEFAULT = true;
    public static final boolean SHOW_FUNCTION_RETURN_TYPE_DEFAULT = true;
    public static final boolean SHOW_PROPERTY_TYPE_DEFAULT = false;
    public static final boolean SHOW_LOCAL_VARIABLE_TYPE_DEFAULT = false;
    public static final boolean SHOW_METHOD_CHAIN_INLAY_HINTS_DEFAULT = true;
    public static final boolean ALIGN_METHOD_CHAIN_INLAY_HINTS_DEFAULT = true;
    public static final int UNIQUE_TYPES_TO_SHOW_METHOD_CHAINS_DEFAULT = 3;
    public static final int PRESENTATION_LENGTH_DEFAULT = 45;
    public static final boolean SHOW_OBVIOUS_TYPE_DEFAULT = false;

    public static final int MIN_PRESENTATION_LENGTH = 1;
    public static final int MAX_PRESENTATION_LENGTH = Byte.MAX_VALUE;

    public static ScalaCodeInsightSettings getInstance() {
        return ServiceManager.getService(ScalaCodeInsightSettings.class);
    }

    //private fields are not serialized
    public boolean showTypeHints = SHOW_TYPE_HINTS_DEFAULT;
    public boolean showFunctionReturnType = SHOW_FUNCTION_RETURN_TYPE_DEFAULT;
    public boolean showPropertyType = SHOW_PROPERTY_TYPE_DEFAULT;
    public boolean showLocalVariableType = SHOW_LOCAL_VARIABLE_TYPE_DEFAULT;
    public boolean showMethodChainInlayHints = SHOW_METHOD_CHAIN_INLAY_HINTS_DEFAULT;
    public boolean alignMethodChainInlayHints = ALIGN_METHOD_CHAIN_INLAY_HINTS_DEFAULT;
    public int uniqueTypesToShowMethodChains = UNIQUE_TYPES_TO_SHOW_METHOD_CHAINS_DEFAULT;
    public int presentationLength = PRESENTATION_LENGTH_DEFAULT;
    public boolean showObviousType = SHOW_OBVIOUS_TYPE_DEFAULT;


    public Getter<Boolean> showTypeHintsGetter() {
        return () -> showTypeHints;
    }

    public Setter<Boolean> showTypeHintsSetter() {
        return value -> showTypeHints = value;
    }

    public Getter<Boolean> showFunctionReturnTypeGetter() {
        return () -> showFunctionReturnType;
    }

    public Setter<Boolean> showFunctionReturnTypeSetter() {
        return value -> showFunctionReturnType = value;
    }

    public Getter<Boolean> showPropertyTypeGetter() {
        return () -> showPropertyType;
    }

    public Setter<Boolean> showPropertyTypeSetter() {
        return value -> showPropertyType = value;
    }

    public Getter<Boolean> showLocalVariableTypeGetter() {
        return () -> showLocalVariableType;
    }

    public Setter<Boolean> showLocalVariableTypeSetter() {
        return value -> showLocalVariableType = value;
    }

    public Getter<Boolean> showMethodChainInlayHintsGetter() {
        return () -> showMethodChainInlayHints;
    }

    public Setter<Boolean> showMethodChainInlayHintsSetter() {
        return value -> showMethodChainInlayHints = value;
    }

    public Getter<Boolean> alignMethodChainInlayHintsGetter() {
        return () -> alignMethodChainInlayHints;
    }

    public Setter<Boolean> alignMethodChainInlayHintsSetter() {
        return value -> alignMethodChainInlayHints = value;
    }

    public Getter<Integer> uniqueTypesToShowMethodChainsGetter() {
        return () -> uniqueTypesToShowMethodChains;
    }

    public Setter<Integer> uniqueTypesToShowMethodChainsSetter() {
        return value -> uniqueTypesToShowMethodChains = value;
    }

    public Getter<Integer> presentationLengthGetter() {
        return () -> presentationLength;
    }

    public Setter<Integer> presentationLengthSetter() {
        return value -> presentationLength = value;
    }

    public Getter<Boolean> showObviousTypeGetter() {
        return () -> showObviousType;
    }

    public Setter<Boolean> showObviousTypeSetter() {
        return value -> showObviousType = value;
    }

    @NotNull
    @Override
    public ScalaCodeInsightSettings getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull ScalaCodeInsightSettings settings) {
        XmlSerializerUtil.copyBean(settings, this);
    }
}

