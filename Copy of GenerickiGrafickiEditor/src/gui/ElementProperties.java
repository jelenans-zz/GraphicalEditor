package gui;

import gge.model.Entity;
import gge.model.GGEModel;
import gge.model.GraphElement;
import gge.model.WeakEntity;
import gge.view.GGEView;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Paint;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.plaf.metal.MetalBorders.PaletteBorder;



public class ElementProperties extends JDialog {
	
	public enum ShadowStyle{none,standard,effect3D};

	public static GraphElement selektovanElement;
	public static GGEView currView;

	
	private JTabbedPane tabbedPane;
	
	private JLabel lbLineWidth;
	private JLabel lbLineCap;
	private JLabel lbLineStyle;	// isprekidana,puna....
	

	private JComboBox cbLineWidth;
	private JComboBox cbLineCap;
	private  JComboBox cbLineStyle;

	private JLabel lbColor;

	private JComboBox cbColor;

	private JCheckBox cbGradient;

	private JLabel lbGradient;

	private JLabel lbWidth;

	private JTextField tbWidth;

	private JLabel lbHeight;

	private JTextField tbHeight;

	private JLabel lbFont;

	private JLabel lbFontStyle;

	private JLabel lbFontSize;

	private JComboBox cbFontName;

	private JComboBox cbFontStyle;

	private JComboBox cbFontSize;

	private JLabel lbFontColor;

	private JComboBox cbFontColor;

	private JCheckBox chbUnderline;

	private JLabel lbUnderline;

	private JRadioButton rbNone;

	private JRadioButton rbStandard;

	private JRadioButton rb3DEffect;

	private JButton btnOK;

	private JButton btnCancel;
	private JLabel lbBorderColor;

	private JCheckBox chbFill;
	private JLabel lbFill;
	private JComboBox cbBorderColor;
	
	private JColorChooser colorsShadow;
	private JColorChooser colorsBorder;
	private JColorChooser colorsFill;
	private JColorChooser colorsFont;
	private JColorChooser colorsShadow2;
	private JSplitPane sp;
	private JTextField tfImeElementa;
	
	public ElementProperties(){
		
		setTitle("Element Properties");
		setSize(((MainFrame.getInstance().getSize()).width/3)+170,(MainFrame.getInstance().getSize()).height-150);
		setLocationRelativeTo(MainFrame.getInstance());
		setModal(true);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	
	    colorsShadow= new JColorChooser();
	    colorsShadow.setColor(selektovanElement.getShadow().getColor1());
	    colorsShadow2= new JColorChooser();
	    colorsShadow2.setColor(selektovanElement.getShadow().getColor2());
	    colorsBorder= new JColorChooser();
	    colorsBorder.setColor(selektovanElement.getBorderColor());
	    colorsFill= new JColorChooser();
	    colorsFill.setColor(selektovanElement.getColor());
	    colorsFont= new JColorChooser();
	    colorsFont.setColor(selektovanElement.getFontColor());
	    
		JPanel pLineWidth= new JPanel(new FlowLayout(FlowLayout.LEFT));
		lbLineWidth= new JLabel("Line Width:");
		String[] lineWidths={"1","2","3","4","5"};
		cbLineWidth= new JComboBox(lineWidths);	
		int zaPoredjenje= (int)selektovanElement.getLineStyle().getLineWidth();
		String linDebljina= Integer.toString(zaPoredjenje);

		for(int i=0;i<lineWidths.length;i++)
		{
			if(lineWidths[i].equals(linDebljina))	
			{
				cbLineWidth.setSelectedItem(lineWidths[i]);
				break;
			}
		}

		pLineWidth.add(lbLineWidth);
		pLineWidth.add(cbLineWidth);
		
		JPanel pStyle= new JPanel(new FlowLayout(FlowLayout.LEFT));
		lbLineStyle= new JLabel("Line Style:");
		String[] lineStyles= {"________","--------------"};
		cbLineStyle= new JComboBox(lineStyles);
		String stilLinije= selektovanElement.getLineStyleName();
		if(stilLinije.equals("puna"))
			cbLineStyle.setSelectedItem(lineStyles[0]);
		else
			cbLineStyle.setSelectedItem(lineStyles[1]);
		pStyle.add(lbLineStyle);
		pStyle.add(cbLineStyle);
		
//		JPanel pCap= new JPanel(new FlowLayout(FlowLayout.LEFT));
//		lbLineCap= new JLabel("Cap:");
//		cbLineCap= new JComboBox();
//		pCap.add(lbLineCap);
//		pCap.add(cbLineCap);
		
		JPanel pBlah= new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel joj= new JLabel("_______________________________________________________________________");
		pBlah.add(joj);
		
		JPanel pImeElementa= new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		JLabel lbImeElementa= new JLabel("Naziv: ");
		tfImeElementa= new JTextField(15);
		tfImeElementa.setText(selektovanElement.getName());
		pImeElementa.add(lbImeElementa);
		pImeElementa.add(tfImeElementa);
		pImeElementa.add(new JLabel());
		
		Font newLabelFont=new Font(lbImeElementa.getFont().getName(),Font.ITALIC+Font.BOLD,lbImeElementa.getFont().getSize());	
		
		JPanel pNaziv= new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		JLabel lbNaziv= new JLabel();  
		lbNaziv.setFont(newLabelFont);
		lbNaziv.setText("__Line Style____________________________________________________________");
		pNaziv.add(lbNaziv);
		pNaziv.add(new JLabel());
		
		
		JPanel pNaziv2= new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		JLabel lbNaziv2= new JLabel();
		lbNaziv2.setFont(newLabelFont);
		lbNaziv2.setText("__Size_________________________________________________________________");
		pNaziv2.add(lbNaziv2);
		pNaziv2.add(new JLabel());
		
		JPanel pWidth= new JPanel(new FlowLayout(FlowLayout.LEFT));
		lbWidth = new JLabel("Width:");
		tbWidth = new JTextField(5);
		tbWidth.setText(Double.toString(selektovanElement.getSize().getWidth()));
		pWidth.add(lbWidth);
		pWidth.add(tbWidth);
		
		JPanel pHeight= new JPanel(new FlowLayout(FlowLayout.LEFT));
		lbHeight = new JLabel("Height:");
		tbHeight = new JTextField(5);
		tbHeight.setText(Double.toString(selektovanElement.getSize().getHeight()));
		pHeight.add(lbHeight);
		pHeight.add(tbHeight);
		
		Box boxStyle = new Box(BoxLayout.Y_AXIS);
		Box boxSize = new Box(BoxLayout.Y_AXIS);
		
		boxSize.add(pNaziv2);
		boxSize.add(pWidth);
		boxSize.add(pHeight);
		
		boxStyle.add(pNaziv);
		boxStyle.add(pLineWidth);
		boxStyle.add(pStyle);
//		boxStyle.add(pCap);
		
		JPanel pElSize= new JPanel(new FlowLayout(FlowLayout.LEFT));
	//	pElSize.add(new JLabel("Size: "));
	//	pElSize.add(new JLabel(""));
		pElSize.add(boxSize);
		JPanel pLiStyle= new JPanel(new FlowLayout(FlowLayout.LEFT));
	//	pLiStyle.add(new JLabel("Line style: "));
	//	pLiStyle.add(new JLabel(""));
		pLiStyle.add(boxStyle);
		
		JPanel pGeneral= new JPanel();
		pGeneral.setLayout(new BoxLayout(pGeneral,BoxLayout.Y_AXIS));
		
//		sp=new JSplitPane(JSplitPane.VERTICAL_SPLIT,pElSize,pLiStyle);
//		int loc= (int)getSize().getHeight();
//		int locReal= loc/2;
//		sp.setDividerLocation(locReal + sp.getInsets().bottom);
		
		pGeneral.add(pBlah);
		pGeneral.add(pImeElementa);
		pGeneral.add(pElSize);
		pGeneral.add(pLiStyle);
//		pGeneral.add(new JLabel("Line style: "));
//		pGeneral.add(boxStyle);
		
		tabbedPane.addTab("General", null, pGeneral);
	

// TAB ATRIBUTI.......................................................................................................

		
		JPanel[] pAtr= new JPanel[selektovanElement.getAtributi().size()];
		JLabel[] lbAtr= new JLabel[selektovanElement.getAtributi().size()];
		JLabel[] lbKeys= new JLabel[selektovanElement.getAtributi().size()];
		JTextField[] tfAtr= new JTextField[selektovanElement.getAtributi().size()];
		final JCheckBox[] chAtr= new JCheckBox[selektovanElement.getAtributi().size()];
		
		for(int i=0;i<selektovanElement.getAtributi().size();i++)
		{
			pAtr[i]=new JPanel(new FlowLayout(FlowLayout.LEFT));
			int j=i+1;
			lbAtr[i]= new JLabel("Attribute_"+j+": ");
			tfAtr[i]= new JTextField(15);

			if(selektovanElement instanceof Entity || selektovanElement instanceof WeakEntity)
			{
				lbAtr[i]= new JLabel("      Key: ");
				chAtr[i]= new JCheckBox();
			}
			tfAtr[i].setText(selektovanElement.getAtributi().get(i).getName());
			pAtr[i].add(lbAtr[i]);
			pAtr[i].add(tfAtr[i]);		
			if(selektovanElement instanceof Entity || selektovanElement instanceof WeakEntity)
			{
				pAtr[i].add(lbAtr[i]);
				pAtr[i].add(chAtr[i]);
			}
		}
 
		
		JPanel pAtributi= new JPanel();
		pAtributi.setLayout(new BoxLayout(pAtributi,BoxLayout.Y_AXIS));
		
		for(JPanel p: pAtr)
			pAtributi.add(p);

//		pGeneral.add(new JLabel("Line style: "));
//		pGeneral.add(boxStyle);
		
		tabbedPane.addTab("Attributes", null, pAtributi);		

// TAB (FILL/BORDER COLOR).......................................................................................................

		
		JPanel pTabFill= new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		AbstractColorChooserPanel[] panelsFill =colorsFill.getChooserPanels();
	    JPanel pFillColors= new JPanel();
	    //jp.add(new Label("Shadow color: "));
	    panelsFill[2].setBorder(new TitledBorder("Fill color:"));
	    panelsFill[2].setSize(50, 50);
	    panelsFill[2].setMaximumSize(new Dimension(50, 50));
	    pFillColors.add(panelsFill[2]);
	    
		AbstractColorChooserPanel[] panelsBorder =colorsBorder.getChooserPanels();
	    JPanel pBorderColor= new JPanel();
	    //jp.add(new Label("Shadow color: "));
	    panelsBorder[2].setBorder(new TitledBorder("Border Color:"));
	    pBorderColor.add(panelsBorder[2]);

		JPanel pFill=new JPanel(new FlowLayout(FlowLayout.LEFT));
		lbFill = new JLabel("Fill:");
		chbFill=new JCheckBox();
		chbFill.setSelected(selektovanElement.isFill());
		pFill.add(lbFill);
		pFill.add(chbFill);
	
		Box boxFill = new Box(BoxLayout.Y_AXIS);

		boxFill.add(pFill);

		
		pTabFill.add(pBorderColor,BorderLayout.EAST);
		pTabFill.add(boxFill);
		pTabFill.add(pFillColors,BorderLayout.EAST);
		
		tabbedPane.addTab("Fill", null, pTabFill);
		
		
		JPanel pFontPanel= new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		JPanel pFont= new JPanel(new FlowLayout(FlowLayout.LEFT));
		lbFont = new JLabel("Font:    ");

		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] fontNames = ge.getAvailableFontFamilyNames();
		
		cbFontName= new JComboBox(fontNames);
		cbFontName.setSelectedItem(selektovanElement.getFontName());
		pFont.add(lbFont);
		pFont.add(cbFontName);
		
		JPanel pFontStyle= new JPanel(new FlowLayout(FlowLayout.LEFT));
		lbFontStyle = new JLabel("Font Style:");
		String[] fontSyle= {"Regular","Bold","Italic", "Bold Italic"};
		cbFontStyle = new JComboBox(fontSyle);
		if(selektovanElement.getFontStyle()==Font.BOLD)
			cbFontStyle.setSelectedItem(fontSyle[1]);
		else if(selektovanElement.getFontStyle()==Font.ITALIC)
			cbFontStyle.setSelectedItem(fontSyle[2]);
		else if(selektovanElement.getFontStyle()==Font.BOLD+Font.ITALIC)
			cbFontStyle.setSelectedItem(fontSyle[3]);
		else
			cbFontStyle.setSelectedItem(fontSyle[0]);
		
		pFontStyle.add(lbFontStyle);
		pFontStyle.add(cbFontStyle);
		
		JPanel pFontSize= new JPanel(new FlowLayout(FlowLayout.LEFT));
		lbFontSize = new JLabel("Font Size:");
			
		String[] fontSize= new String[39];
		for(int i=0;i<39;i++)
		{
			fontSize[i]= Integer.toString(i+10);
		}
		cbFontSize = new JComboBox(fontSize);
		cbFontSize.setSelectedItem(Integer.toString(selektovanElement.getFontSize()));

		pFontSize.add(lbFontSize);
		pFontSize.add(cbFontSize);
		
		
	    AbstractColorChooserPanel[] panelsFontColor =colorsFont.getChooserPanels();
	    JPanel pFontColor= new JPanel(new FlowLayout(FlowLayout.LEFT));
	    //jp.add(new Label("Shadow color: "));
	    panelsFontColor[1].setBorder(new TitledBorder("Font color:"));
	    pFontColor.add(panelsFontColor[1]);

//	    JPanel pFontUnderline= new JPanel(new FlowLayout(FlowLayout.LEFT));
//
//		lbUnderline= new JLabel("Underline");
//		chbUnderline= new JCheckBox();
//		chbUnderline.setSelected(selektovanElement.isUnderline());
//
//		pFontUnderline.add(lbUnderline);
//		pFontUnderline.add(chbUnderline);

		
		Box boxFont = new Box(BoxLayout.Y_AXIS);
		
		boxFont.add(pFont);
		boxFont.add(pFontStyle);
		boxFont.add(pFontSize);
	//	boxFont.add(pFontUnderline);
		
		pFontPanel.add(boxFont);
		pFontPanel.add(pFontColor,BorderLayout.EAST);
		
		tabbedPane.addTab("Font", null, pFontPanel);
		
		JPanel pShadow= new JPanel(new FlowLayout(FlowLayout.LEFT));
//		ButtonGroup grShadow= new ButtonGroup();
//		rbNone= new JRadioButton("None");
//	    rbStandard= new JRadioButton("Standard");
//		rb3DEffect= new JRadioButton("3D effect");
		
		JPanel pGradient= new JPanel(new FlowLayout(FlowLayout.LEFT));
		lbGradient = new JLabel("Gradient:");
		cbGradient = new JCheckBox();
		cbGradient.setSelected(selektovanElement.isShading());
		pGradient.add(lbGradient); 
		pGradient.add(cbGradient);

	    AbstractColorChooserPanel[] panels =colorsShadow.getChooserPanels();
	    JPanel jp= new JPanel();
	    //jp.add(new Label("Shadow color: "));
	    panels[1].setBorder(new TitledBorder("Start color:"));
	    jp.add(panels[1]);
		//colors.getSelectionModel().addChangeListener(this);


		AbstractColorChooserPanel[] panelsEnd =colorsShadow2.getChooserPanels();
	    JPanel jpEnd= new JPanel();
	    //jp.add(new Label("Shadow color: "));
		panelsEnd[2].setBorder(new TitledBorder("End color:"));;
	    jpEnd.add(panelsEnd[2]);
	    
//		grShadow.add(rbNone);
//		grShadow.add(rbStandard);
//		grShadow.add(rb3DEffect);
//		
//     	Box boxColor = new Box(BoxLayout.Y_AXIS);
//     	boxColor.add(new JLabel("Shadow:"));
//     	boxColor.add(rbNone);
//     	boxColor.add(rbStandard);
//     	boxColor.add(rb3DEffect);
		

	//	pShadow.add(boxColor);
		pShadow.add(pGradient);
		pShadow.add(jp,BorderLayout.EAST);
		pShadow.add(jpEnd,BorderLayout.SOUTH);	
		
		tabbedPane.addTab("Shadow", null, pShadow);
	    
		//tabbedPane.addTab("Text Alignment", null, new JPanel());
	
		//tabbedPane.setSelectedComponent(pStyle);
		JPanel buttons= new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnOK= new JButton("OK");
		btnOK.setPreferredSize(new Dimension(80, 30));
		btnOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			
				if(selektovanElement instanceof Entity)
				{
					for(int i=0;i<selektovanElement.getAtributi().size();i++)
					{
						if(chAtr[i].isSelected())
						 {
							selektovanElement.getAtributi().get(i).setUnderline(true);
							((Entity)selektovanElement).getKey().add(selektovanElement.getAtributi().get(i));
						 }
					}

					
				} else if(selektovanElement instanceof WeakEntity)
				{
					for(int i=0;i<selektovanElement.getAtributi().size();i++)
					{
						if(chAtr[i].isSelected())
						 {
							selektovanElement.getAtributi().get(i).setUnderline(true);
							((WeakEntity)selektovanElement).getKey().add(selektovanElement.getAtributi().get(i));
						 }
					}
				}
		
				 ShadowStyle stil=null;
		
//				 if (rbNone.isSelected()==true) 
//						stil= ShadowStyle.none;
//				 else if(rbStandard.isSelected()==true)
//						stil= ShadowStyle.standard;		
//				 else if(rb3DEffect.isSelected()==true)
//						stil= ShadowStyle.effect3D;	
				
				 boolean fill= chbFill.isSelected();
			 
				double elWidth= Double.parseDouble(tbWidth.getText());
				double elHeight= Double.parseDouble(tbHeight.getText());
				 
				GGEModel model= currView.getGGEModel();

				model.setElementProperties(
						selektovanElement,
						tfImeElementa.getText(),
						cbLineWidth.getSelectedItem().toString(),
						cbLineStyle.getSelectedItem().toString(),
						colorsBorder.getColor(),
						fill,
						colorsFill.getColor(),
						cbGradient.isSelected(),
						elWidth,
						elHeight,
						cbFontName.getSelectedItem().toString(),
						cbFontStyle.getSelectedItem().toString(),
						cbFontSize.getSelectedItem().toString(),
						colorsFont.getColor(),
						chbUnderline.isSelected(),
						stil,
						colorsShadow.getColor(),
						colorsShadow2.getColor()
						);
				
				
				MainFrame.getInstance().getView().repaint();
				ElementProperties.this.dispose();
				ElementProperties.this.setVisible(false);
				
				
			}
		});
		btnCancel= new JButton("Cancel");
		btnCancel.setPreferredSize(new Dimension(80, 30));
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ElementProperties.this.dispose();
				ElementProperties.this.setVisible(false);
				
			}
		});
		
		buttons.add(btnOK);
		buttons.add(btnCancel);
		
	//	JPanel tabovi= new JPanel();
		
		add(tabbedPane);
		add(buttons,BorderLayout.SOUTH);
	}

//	public void stateChanged(ChangeEvent e) {
//	    Color newColor = colors.getColor();
//	   // banner.setForeground(newColor);
//	}
}


