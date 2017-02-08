Please note: I do no longer maintain this project and cannot ensure that it will work on your system / in your context.

SFM tool suite
==============

The SFM tool suite allows to model and use service feature models (SFMs) with the goal of representing and selecting software service variants.
The architecture consists of the following parts (as illustrated in the figure):

![Architecture of the SFM tool suite](/architecture_complete.png "Architecture of the SFM tool suite")

* **SFM designer**
  The SFM designer is the modeling environment to create and edit SFMs.
  It is based upon Eclipse and implemented using the Eclipse Modeling Framework (EMF).

* **Valuation server**
  The valuation server exposes preference-based ranking for participatory selection of variants represented in an SFM.

* **Collaboration server**
  The collaboration server handles the coordination required for asynchronous collaboration in service feature modeling.

* **Interaction platform**
  The interaction platform provides user interfaces allowing stakeholders to express their preferences with respect to an SFM’s attribute types.
  The interaction platform is not published here.


The MIT License (MIT)

Copyright (c) 2014 Erik Wittern

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
