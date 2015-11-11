<?xml version="1.0" encoding="UTF-8"?>
<config xmlns="http://www.w3schools.com"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://www.w3schools.com readXML.xsd">

  <arguments>
<config>
  <program>
		<name>pizzashop</name>
		
		<description>order a pizza</description>
		
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
			<defaults>no drink</defaults>
			<shorthand>d</shorthand>
	  </namedArgument>
	  
	  <namedArgument>
			<name>togo</name>
			<type>BOOLEAN</type>
			<description>Is the order to go?</description>
			<defaults>false</defaults>
			<shorthand>t</shorthand>
	  </namedArgument>

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
	</program>

</config> 

