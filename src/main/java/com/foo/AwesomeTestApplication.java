/*
 * Copyright 2009 IT Mill Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.foo;

import com.foo.widget.AwesomeRichTextArea;
import com.vaadin.Application;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Window;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class AwesomeTestApplication extends Application {
	@Override
	public void init() {
		final Window window = new Window("Awesome application to test AwesomeRichTextArea");
		setMainWindow(window);

		final AwesomeRichTextArea awesomeRichTextArea = new AwesomeRichTextArea();
		window.addComponent(awesomeRichTextArea);

		Button button = new Button("Show me what is selected");
		button.addListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				window.showNotification("Selected text is: " + awesomeRichTextArea.getSelectedText());
			}
		});

		window.addComponent(button);

	}

}
