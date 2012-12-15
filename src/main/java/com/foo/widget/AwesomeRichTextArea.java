package com.foo.widget;

import static com.foo.widget.client.VAwesomeRichTextArea.SELECTED_TEXT_VARIABLE;

import java.util.Map;

import com.foo.widget.client.VAwesomeRichTextArea;
import com.vaadin.terminal.PaintException;
import com.vaadin.terminal.PaintTarget;
import com.vaadin.ui.ClientWidget;
import com.vaadin.ui.RichTextArea;

@ClientWidget(VAwesomeRichTextArea.class)
public class AwesomeRichTextArea extends RichTextArea {
	private static final long serialVersionUID = 1L;

	private String selectedText;

	public String getSelectedText() {
		return selectedText;
	}

	/**
	 * Metoda, która odbiera od przeglądarki wiadomość, że po stronie klienta
	 * coś się zmieniło.
	 */
	@Override
	public void changeVariables(Object source, Map<String, Object> variables) {
		super.changeVariables(source, variables);
		if (variables.containsKey(SELECTED_TEXT_VARIABLE)) {
			selectedText = (String) variables.get(SELECTED_TEXT_VARIABLE);
		}
	}

	/**
	 * Metoda, która wysyła do przeglądarki informacje o zmianach po stronie
	 * serwera.
	 */
	@Override
	public void paintContent(PaintTarget target) throws PaintException {
		super.paintContent(target);
		// serwer nie wysyła na razie nic nowego, więc nie trzeba tu nic dodawać
	}
}
