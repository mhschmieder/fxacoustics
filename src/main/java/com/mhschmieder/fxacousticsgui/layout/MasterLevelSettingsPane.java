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
package com.mhschmieder.fxacousticsgui.layout;

import com.mhschmieder.commonstoolkit.util.ClientProperties;
import com.mhschmieder.fxacousticsgui.ProcessingLabelFactory;
import com.mhschmieder.fxacousticsgui.control.MasterLevelSettingsControls;
import com.mhschmieder.fxacousticsgui.model.MasterLevelSettings;
import com.mhschmieder.fxguitoolkit.GuiUtilities;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

// TODO: Switch to using MasterLevelSettings with Data Binding.
public final class MasterLevelSettingsPane extends BorderPane {

    // Declare static constant to use for symbolically referencing grid column
    // indices, to ensure no errors, and ease of extensibility.
    public static final int               COLUMN_FIRST             = 0;
    public static final int               COLUMN_POLARITY          = COLUMN_FIRST;
    public static final int               COLUMN_GAIN              = COLUMN_POLARITY + 1;
    public static final int               COLUMN_MUTE              = COLUMN_GAIN + 1;
    public static final int               COLUMN_LAST              = COLUMN_MUTE;
    public static final int               NUMBER_OF_COLUMNS        =
                                                            ( COLUMN_LAST - COLUMN_FIRST ) + 1;

    // Declare static constant to use for symbolically referencing grid row
    // indices, to ensure no errors, and ease of extensibility.
    public static final int               ROW_HEADER               = 0;
    public static final int               ROW_SETTINGS_FIRST       = ROW_HEADER + 1;
    public static final int               ROW_SETTINGS_LAST        = ROW_SETTINGS_FIRST;
    public static final int               ROW_LAST                 = ROW_SETTINGS_LAST;

    // Keep track of how many unique Column Headers there are (due to spanning).
    public static final int               NUMBER_OF_COLUMN_HEADERS = NUMBER_OF_COLUMNS;

    // Declare the main GUI nodes that are needed beyond initialization time.
    protected GridPane                    _masterLevelSettingsGrid;

    // Give global scope to the Master Level Settings Group so we can access the
    // controls directly without casting from Node via getChildren().
    protected MasterLevelSettingsControls _masterLevelSettingsControls;

    // TODO: Use the Master Level Settings observables for Data Binding.
    protected MasterLevelSettings         _masterLevelSettings;

    // Cache the Client Properties (System Type, Locale, etc.).
    protected ClientProperties          _clientProperties;

    // //////////////////////////////////////////////////////////////////////////
    // Constructors and Initialization
    public MasterLevelSettingsPane( final ClientProperties pClientProperties,
                                    final boolean defaultToNegativeGain ) {
        // Always call the superclass constructor first!
        super();

        _clientProperties = pClientProperties;

        try {
            initPane( defaultToNegativeGain );
        }
        catch ( final Exception ex ) {
            ex.printStackTrace();
        }
    }

    public MasterLevelSettings getMasterLevelSettings() {
        return _masterLevelSettings;
    }

    private void initPane( final boolean defaultToNegativeGain ) {
        // Make the grid of individual Master Level Settings controls.
        _masterLevelSettingsGrid = new GridPane();

        // We center the column header labels to follow Compass conventions.
        final Label polarityLabel = GuiUtilities.getColumnHeader( 
                ProcessingLabelFactory.getPolarityLabel() );
        final Label gainLabel = GuiUtilities.getColumnHeader( 
                ProcessingLabelFactory.getGainLabel() );
        final Label muteLabel = GuiUtilities.getColumnHeader( 
                ProcessingLabelFactory.getMuteLabel() );

        // Force all the labels to center within the grid.
        GridPane.setHalignment( polarityLabel, HPos.CENTER );
        GridPane.setHalignment( gainLabel, HPos.CENTER );
        GridPane.setHalignment( muteLabel, HPos.CENTER );

        _masterLevelSettingsGrid.setPadding( new Insets( 6.0d ) );
        _masterLevelSettingsGrid.setHgap( 4.0d );
        _masterLevelSettingsGrid.setVgap( 2.0d );
        _masterLevelSettingsGrid.setAlignment( Pos.TOP_CENTER );

        _masterLevelSettingsGrid.add( polarityLabel, COLUMN_POLARITY, ROW_HEADER );
        _masterLevelSettingsGrid.add( gainLabel, COLUMN_GAIN, ROW_HEADER );
        _masterLevelSettingsGrid.add( muteLabel, COLUMN_MUTE, ROW_HEADER );

        _masterLevelSettingsControls = new MasterLevelSettingsControls( _clientProperties,
                                                                        defaultToNegativeGain,
                                                                        true );

        _masterLevelSettingsGrid.add( _masterLevelSettingsControls._polarityToggleButton,
                                      COLUMN_POLARITY,
                                      ROW_SETTINGS_FIRST );

        _masterLevelSettingsControls._polarityToggleButton.selectedProperty()
                .addListener( ( observableValue,
                                oldValue,
                                newValue ) -> syncPolarityToView( newValue ) );

        _masterLevelSettingsGrid
                .add( _masterLevelSettingsControls._gainEditor, COLUMN_GAIN, ROW_SETTINGS_FIRST );

        _masterLevelSettingsControls._gainEditor.focusedProperty()
                .addListener( ( observableValue, oldValue, newValue ) -> {
                    if ( !newValue ) {
                        syncGainToView();
                    }
                } );

        _masterLevelSettingsGrid.add( _masterLevelSettingsControls._muteToggleButton,
                                      COLUMN_MUTE,
                                      ROW_SETTINGS_FIRST );

        _masterLevelSettingsControls._muteToggleButton.selectedProperty()
                .addListener( ( observableValue,
                                oldValue,
                                newValue ) -> syncMuteToView( newValue ) );

        // Center the grid for the most balanced layout.
        setCenter( _masterLevelSettingsGrid );

        setAlignment( _masterLevelSettingsGrid, Pos.CENTER );
        setPadding( new Insets( 6.0d ) );
    }

    public void setMasterLevelSettings( final MasterLevelSettings masterLevelSettings ) {
        _masterLevelSettings = masterLevelSettings;

        // Sync the view to show the new Master Level Settings.
        syncViewToMasterLevelSettings();
    }

    public void syncGainToView() {
        final double newProcessorGain = _masterLevelSettingsControls._gainEditor.getValue();
        final double oldProcessorGain = _masterLevelSettings.getGain();
        final boolean processorGainChanged =
                                           ( float ) newProcessorGain != ( float ) oldProcessorGain;
        if ( processorGainChanged ) {
            // Reset the Processor Gain if it changed.
            _masterLevelSettings.setGain( newProcessorGain );
        }
    }

    private void syncMuteToView( final boolean muted ) {
        final boolean oldProcessorMuted = _masterLevelSettings.isMuted();
        final boolean processorMutedChanged = oldProcessorMuted != muted;

        if ( processorMutedChanged ) {
            _masterLevelSettings.setMuted( muted );
        }
    }

    private void syncPolarityToView( final boolean polarityReversed ) {
        final boolean oldPolarityReversed = _masterLevelSettings.isPolarityReversed();
        final boolean polarityChanged = oldPolarityReversed != polarityReversed;

        if ( polarityChanged ) {
            _masterLevelSettings.setPolarityReversed( polarityReversed );
        }
    }

    public void syncViewToMasterLevelSettings() {
        final boolean polarityReversed = _masterLevelSettings.isPolarityReversed();
        _masterLevelSettingsControls._polarityToggleButton.setSelected( polarityReversed );

        final double processorGain = _masterLevelSettings.getGain();
        _masterLevelSettingsControls._gainEditor.setValue( processorGain );

        final boolean muted = _masterLevelSettings.isMuted();
        _masterLevelSettingsControls._muteToggleButton.setSelected( muted );
    }
}
