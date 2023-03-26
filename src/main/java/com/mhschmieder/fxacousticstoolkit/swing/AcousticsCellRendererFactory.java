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
package com.mhschmieder.fxacousticstoolkit.swing;

import javax.swing.table.DefaultTableCellRenderer;

import com.mhschmieder.fxgraphicstoolkit.paint.ColorConstants;
import com.mhschmieder.fxgraphicstoolkit.paint.ColorUtilities;
import com.mhschmieder.guitoolkit.table.ToggleButtonCellRenderer;

public class AcousticsCellRendererFactory {

    public static DefaultTableCellRenderer makeMuteCellRenderer( final float fontSize ) {
        return new ToggleButtonCellRenderer( false,
                                             fontSize,
                                             "Muted", //$NON-NLS-1$
                                             "Mute", //$NON-NLS-1$
                                             ColorUtilities
                                                     .getColor( ColorConstants.MUTED_BACKGROUND_COLOR ),
                                             ColorUtilities
                                                     .getColor( ColorConstants.UNMUTED_BACKGROUND_COLOR ),
                                             ColorUtilities
                                                     .getColor( ColorConstants.MUTED_FOREGROUND_COLOR ),
                                             ColorUtilities
                                                     .getColor( ColorConstants.UNMUTED_FOREGROUND_COLOR ) );
    }

}
