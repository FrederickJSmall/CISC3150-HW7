package dirtree;

import java.io.IOException;

public class DirTree {
	public static void main (String[] args)
	{
		TreeDiagram treeDiagram = new TreeDiagram();
		try
		{
		    //treeDiagram.tree("D:\\Projects",0);
			treeDiagram.Open();
			treeDiagram.tree("/Projects",0);
			treeDiagram.Close();
			treeDiagram = null;
		}
		catch (IOException ex)
		{
			System.out.println("Error encouneted in process");
			System.out.println(ex.getStackTrace());
		}
	}
}
