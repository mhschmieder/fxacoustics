/**
 * MIT License
 *
 * Copyright (c) 2020, 2023 Mark Schmieder
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
 * This file is part of the FxAcousticsGui Library
 *
 * You should have received a copy of the MIT License along with the
 * FxAcousticsGui Library. If not, see <https://opensource.org/licenses/MIT>.
 *
 * Project: https://github.com/mhschmieder/fxacousticsgui
 */
package com.mhschmieder.fxacousticsgui.control;

import com.mhschmieder.commonstoolkit.util.ClientProperties;

import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;

public final class MasterLevelSettingsControls {

    public static final double GAIN_MINIMUM_DB = Double.NEGATIVE_INFINITY;
    public static final double GAIN_MAXIMUM_DB = 0.0d;

    public ToggleButton        _polarityToggleButton;
    public GainEditor          _gainEditor;
    public ToggleButton        _muteToggleButton;

    @SuppressWarnings("nls")
    public MasterLevelSettingsControls( final ClientProperties clientProperties,
                                        final boolean defaultToNegativeGain,
                                        final boolean channelStripContext ) {
        // Always call the superclass constructor first!
        super();

        _polarityToggleButton =
                              AcousticsLabeledControlFactory.getPolarityToggleButton( true, false );

        _gainEditor = AcousticsControlFactory
                .getGainEditor( clientProperties,
                                " dB",
                                GAIN_MINIMUM_DB,
                                GAIN_MAXIMUM_DB,
                                0.0d,
                                defaultToNegativeGain );

        _muteToggleButton = AcousticsLabeledControlFactory.getMuteToggleButton( true, false );

        // Try to get the buttons to be as tall as possible.
        GridPane.setFillHeight( _polarityToggleButton, true );
        GridPane.setFillHeight( _muteToggleButton, true );

        // Try to set widths that force insets in the buttons.
        _polarityToggleButton.setPrefWidth( 120d );
        _muteToggleButton.setPrefWidth( 80d );

        // Try to set smallish widths for the editable filter values.
        _gainEditor.setPrefWidth( 100d );

        // Make sure all the buttons stretch to match the height of the first
        // button in layout order (forward references do not apply the match).
        if ( channelStripContext ) {
            _gainEditor.prefHeightProperty().bind( _polarityToggleButton.heightProperty() );
            _muteToggleButton.prefHeightProperty().bind( _polarityToggleButton.heightProperty() );
        }
    }
}

