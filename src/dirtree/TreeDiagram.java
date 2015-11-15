package dirtree;

import java.io.File;

public class TreeDiagram {

	public static void tree(String rootDirectory,int level)
	{
			level++;
			File file = new File(rootDirectory);
			
			String[] fileList = file.list();
			
			if (fileList == null) return;
			
			for(String path : fileList )
			{
				String fullPath = rootDirectory + "\\" + path;
				File checkfile = new File(fullPath);
				if (checkfile.isDirectory() == true)
				{
					System.out.printf("%10d",level);
					for (int i=0;i<level;i++)
						System.out.print("-");
					System.out.print("|");
					System.out.println(path);
					tree(fullPath,level);
				}
			}
	}
	
}
