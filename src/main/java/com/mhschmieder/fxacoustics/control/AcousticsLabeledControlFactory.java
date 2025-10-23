/*
 * MIT License
 *
 * Copyright (c) 2020, 2025 Mark Schmieder
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 * This file is part of the FxAcoustics Library
 *
 * You should have received a copy of the MIT License along with the FxAcoustics
 * Library. If not, see <https://opensource.org/licenses/MIT>.
 *
 * Project: https://github.com/mhschmieder/fxacoustics
 */
package com.mhschmieder.fxacoustics.control;

import com.mhschmieder.fxcontrols.control.ControlUtilities;
import com.mhschmieder.jcommons.util.ClientProperties;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class AcousticsLabeledControlFactory {

    // NOTE: We must substitute "." for resource directory tree delimiters.
    public static final String BUNDLE_NAME = "properties.AcousticsActionLabels";

    /**
     * The default constructor is disabled, as this is a static factory class.
     */
    private AcousticsLabeledControlFactory() {}

    @SuppressWarnings("nls")
    public static Label getSplRangeLabel( final ClientProperties clientProperties ) {
        return ControlUtilities
                .getLabeledLabel( clientProperties, BUNDLE_NAME, "settings", "splRange" );
    }

    @SuppressWarnings("nls")
    public static CheckBox getAutoRangeSplCheckBox( final ClientProperties clientProperties ) {
        return ControlUtilities
                .getLabeledCheckBox( clientProperties, BUNDLE_NAME, "settings", "autoRangeSpl" );
    }

    @SuppressWarnings("nls")
    public static Label getDitheringLabel( final ClientProperties clientProperties ) {
        return ControlUtilities
                .getLabeledLabel( clientProperties, BUNDLE_NAME, "test", "ditheringAmount" );
    }

    @SuppressWarnings("nls")
    public static CheckBox getUseDitheringCheckBox( final ClientProperties clientProperties ) {
        return ControlUtilities
                .getLabeledCheckBox( clientProperties, BUNDLE_NAME, "test", "useDithering" );
    }
}
