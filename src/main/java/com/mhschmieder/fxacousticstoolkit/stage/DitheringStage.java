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
 * This file is part of the FxAcousticsToolkit Library
 *
 * You should have received a copy of the MIT License along with the
 * FxAcousticsToolkit Library. If not, see <https://opensource.org/licenses/MIT>.
 *
 * Project: https://github.com/mhschmieder/fxacousticstoolkit
 */
package com.mhschmieder.fxacousticstoolkit.stage;

import com.mhschmieder.commonstoolkit.branding.ProductBranding;
import com.mhschmieder.commonstoolkit.util.ClientProperties;
import com.mhschmieder.fxacousticstoolkit.layout.DitheringPane;
import com.mhschmieder.fxguitoolkit.action.ToolsActions;
import com.mhschmieder.fxguitoolkit.control.PredictToolBar;
import com.mhschmieder.fxguitoolkit.stage.XStage;

import javafx.scene.Node;
import javafx.scene.control.ToolBar;

public final class DitheringStage extends XStage {

    public static final String DITHERING_FRAME_TITLE_DEFAULT = "Dithering Amount"; //$NON-NLS-1$

    // Declare the actions.
    public ToolsActions        _toolsActions;

    // Declare the main tool bar.
    public PredictToolBar      _toolBar;

    // Declare the main content pane.
    public DitheringPane       _ditheringPane;
    
    // Initial value for dithering disablement (can't be passed to layout pane).
    protected final boolean _initialDisableDithering;

    @SuppressWarnings("nls")
    public DitheringStage( final ProductBranding productBranding,
                           final ClientProperties pClientProperties,
                           final boolean initialDisableDithering ) {
        // Always call the superclass constructor first!
        super( DITHERING_FRAME_TITLE_DEFAULT, "dithering", productBranding, pClientProperties );
        
        _initialDisableDithering = initialDisableDithering;

        initStage();
    }

    public double getDitheringAmount() {
        // Forward this method to the Dithering Pane.
        return _ditheringPane.getDitheringAmount();
    }

    @SuppressWarnings("nls")
    private void initStage() {
        // First have the superclass initialize its content.
        initStage( "/icons/yusukeKamiyamane/ImageBlur16.png", 240d, 120d, false );
    }

    public boolean isUseDithering() {
        // Forward this method to the Dithering Pane.
        return _ditheringPane.isUseDithering();
    }

    // Load the relevant actions for this Stage.
    @Override
    protected void loadActions() {
        // Make all of the actions.
        _toolsActions = new ToolsActions( clientProperties );
    }

    @Override
    protected Node loadContent() {
        // Instantiate and return the custom Content Node.
        _ditheringPane = new DitheringPane( clientProperties, _initialDisableDithering );
        return _ditheringPane;
    }

    // Add the Tool Bar for this Stage.
    @Override
    public ToolBar loadToolBar() {
        // Build the Tool Bar for this Stage.
        _toolBar = new PredictToolBar( clientProperties, _toolsActions );

        // Return the Tool Bar so the superclass can use it.
        return _toolBar;
    }

    // NOTE: This is the method to use when updating from Preferences.
    public void updateDithering( final boolean useDithering, final double ditheringAmount ) {
        // Forward this method to the Dithering Pane.
        _ditheringPane.updateDithering( useDithering, ditheringAmount );
    }
}