<?xml version="1.0" encoding="UTF-8"?>
<config>

  <arguments>
  
	  <positionalArgument>
			<name>size</name>
			<type>STRING</type>
			<description>The size of the pizza(small, medium, large).</description>
	  </positionalArgument>
	  
	  <positionalArgument>
			<name>shape</name>
			<type>STRING</type>
			<description>The shape of the pizza(round, square).</description>
	  </positionalArgument>
	  
	  <positionalArgument>
			<name>toppings</name>
			<type>INTEGER</type>
			<description>The number of toppings.</description>
	  </positionalArgument>
	  
	  <positionalArgument>
			<name>quantity</name>
			<type>INTEGER</type>
			<description>The number of this type of pizza.</description>
	  </positionalArgument>
	  
	  <namedArgument>
			<name>drink</name>
			<type>STRING</type>
			<description>What drink will you have?</description>
			<default>no drink</default>
			<shorthand>d</shorthand>
	  </namedArgument>
	  
	  <namedArgument>
			<name>togo</name>
			<type>BOOLEAN</type>
			<description>Is the order to go?</description>
			<default>false</default>
			<shorthand>t</shorthand>
	  </namedArgument>


  </arguments>

</config> 

