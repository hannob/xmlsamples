// SPDX-License-Identifier: 0BSD

using System.Xml.Linq;
using System;

string[] argv = Environment.GetCommandLineArgs();
﻿using StreamReader reader = new(argv[1]);
string text = reader.ReadToEnd();
XDocument doc = XDocument.Parse(text);
Console.WriteLine(doc);
