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
package com.mhschmieder.fxacousticsgui.stage;

import com.mhschmieder.commonstoolkit.branding.ProductBranding;
import com.mhschmieder.commonstoolkit.util.ClientProperties;
import com.mhschmieder.fxacousticsgui.layout.SplRangePane;
import com.mhschmieder.fxguitoolkit.action.ToolsActions;
import com.mhschmieder.fxguitoolkit.control.PredictToolBar;
import com.mhschmieder.fxguitoolkit.stage.XStage;

import javafx.scene.Node;
import javafx.scene.control.ToolBar;

public final class SplRangeStage extends XStage {

    public static final String SPL_RANGE_FRAME_TITLE_DEFAULT = "Sound Field SPL Range"; //$NON-NLS-1$

    // Declare the actions.
    public ToolsActions        _toolsActions;

    // Declare the main tool bar.
    public PredictToolBar      _toolBar;

    // Declare the main content pane.
    public SplRangePane        _splRangePane;
    
    // Flag for whether to allow extended SPL Range values.
    protected final boolean _useExtendedRange;

    @SuppressWarnings("nls")
    public SplRangeStage( final ProductBranding productBranding,
                          final ClientProperties pClientProperties,
                          final boolean useExtendedRange ) {
        // Always call the superclass constructor first!
        super( SPL_RANGE_FRAME_TITLE_DEFAULT, "splRange", productBranding, pClientProperties );
        
        _useExtendedRange = useExtendedRange;

        try {
            initStage();
        }
        catch ( final Exception ex ) {
            ex.printStackTrace();
        }
    }

    public int getSplRangeDb() {
        // Forward this method to the SPL Range Pane.
        return _splRangePane.getSplRangeDb();
    }

    @SuppressWarnings("nls")
    private void initStage() {
        // First have the superclass initialize its content.
        initStage( "/icons/mhschmieder/SplRange16.png", 300d, 180d, false );
    }

    public boolean isAutoRangeSpl() {
        // Forward this method to the SPL Range Pane.
        return _splRangePane.isAutoRangeSpl();
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
        _splRangePane = new SplRangePane( clientProperties, _useExtendedRange );
        return _splRangePane;
    }

    // Add the Tool Bar for this Stage.
    @Override
    public ToolBar loadToolBar() {
        // Build the Tool Bar for this Stage.
        _toolBar = new PredictToolBar( clientProperties, _toolsActions );

        // Return the Tool Bar so the superclass can use it.
        return _toolBar;
    }

    public void updateSplRange( final boolean autoRangeSpl, final int splRangeDb ) {
        // Forward this method to the SPL Range Pane.
        _splRangePane.updateSplRange( autoRangeSpl, splRangeDb );
    }
}
