package com.foo.widget.client;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.user.client.ui.IndexedPanel;
import com.google.gwt.user.client.ui.RichTextArea;
import com.vaadin.terminal.gwt.client.ApplicationConnection;
import com.vaadin.terminal.gwt.client.UIDL;
import com.vaadin.terminal.gwt.client.ui.richtextarea.VRichTextArea;

public class VAwesomeRichTextArea extends VRichTextArea implements MouseUpHandler {
	public static final String SELECTED_TEXT_VARIABLE = "selectedText";

	public VAwesomeRichTextArea() {
		getRichTextArea().addDomHandler(this, MouseUpEvent.getType());
	}

	/**
	 * Dość paskudny hack, za pomocą którego dostajemy się do zwrapowanej przez
	 * VRichTextArea instancji RichTextArea, która to niestety jest w prywatnym
	 * polu...
	 * 
	 * @return
	 */
	private RichTextArea getRichTextArea() {
		return (RichTextArea) ((IndexedPanel) getWidget()).getWidget(1);
	}

	/**
	 * Metoda odbierająca od serwera informacje o zmianach.
	 */
	@Override
	public void updateFromUIDL(UIDL uidl, ApplicationConnection client) {
		super.updateFromUIDL(uidl, client);
		// serwer nie wysyła na razie nic nowego, więc nie trzeba tu nic dodawać
	}

	/**
	 * Metoda wysyłająca do serwera informację o zaznaczonym tekście przy każdym
	 * puszczeniu lewego przycisku myszy. To jest przykładowe zachowanie -
	 * kwestia kiedy wysyłać informację do serwera jest do przemyślenia w
	 * kontekście konkretnego użycia.
	 */
	public void onMouseUp(MouseUpEvent event) {
		if (event.getNativeButton() == NativeEvent.BUTTON_LEFT) {
			client.updateVariable(client.getPid(this), SELECTED_TEXT_VARIABLE, getSelectedText(), true);
		}
	}

	/**
	 * To trzeba jakoś sprytnie zaimplementować, pewnie z użyciem javascriptu.
	 */
	private String getSelectedText() {
		return "selected text";
	}

}
