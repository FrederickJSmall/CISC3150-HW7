package dirtree;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TreeDiagram {
	
	FileWriter writer;
	
	public void Open() throws IOException
	{
		writer = new FileWriter("dir_tree.txt");		
	}
	public void Close() throws IOException
	{
		writer.flush();
		writer.close();
	}
	public void tree(String rootDirectory,int level) throws IOException
	{
		String message = String.format("%s\n",rootDirectory);
		System.out.printf(message);
		writer.write(message);
		displaySubTree(rootDirectory,level);
	}
	public void displaySubTree(String rootDirectory,int level) throws IOException
	{
			level++;
			File file = new File(rootDirectory);
			
			String[] fileList = file.list();
			
			if (fileList == null) return;
			
			for(String path : fileList )
			{
				String fullPath = rootDirectory + "/" + path;
				File checkfile = new File(fullPath);
				if (checkfile.isDirectory() == true)
				{
					String message = String.format("%010d|",level);
					System.out.printf(message);
					writer.write(message);
					for (int i=1;i<level;i++)
					{
						message = "   ";
						System.out.print(message);
						writer.write(message);
					}
					
					if (level==1)
					{
						message = "----";
						System.out.print(message);
						writer.write(message);
					}
					else
					{
						message = "|---";
						System.out.print(message);
						writer.write(message);
					}
					
					System.out.println(path);
					writer.write(path + "\n");

					displaySubTree(fullPath,level);
				}
			}
	}
	//private void output(String message) throws IOException
	//{
	//	writer.write(message);
	//}
	
}
