   M S B A M L   `   `   `  ����  EasyWpfLoginNavigateExample1    +EasyWpfLoginNavigateExample.View.MainWindow   5   	   \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	     � Title$  	Dashboard��5   	   $	��600��6   $
��1000��6(   .��5      �  � RowDefinitions 5   
   �� 5      $	��70* �6   �� 5      $
��500* �6    � ColumnDefinitions 5
   
   �� 5      $
��163* �6   �� 5      $
��829* �6   .+�5   
   � -   5         �Name$ LoggedInPic��5      $
��Left=�6$   $��70��6?   $	��Top=�6K   $	��163��6c   ���	#FF66CCFF.+�5      �� -   5         ��Name$ Title��5      $��Scrum Mangement��6#   $��Right=�6=   $	��Top=�6Y   $��0,16,5,0q�6q   $��28��6�   $	��130��6�   $��13(�6�   $��Century Gothic)�6�   
�������$
��Bold"�6�   �� 5      -   5         ��Name$
 Logo��5      $
��Left=�6"   $��	6,16,0,20q�6=   $��24��6P   $��/Images/smlogo.png��6[   5      � 5   
   $
��Left=�6   $	��497��6*   $	��Top=�67   $	��163��6O   ���	#FF99CCFF$��1��6r   .+�5      � -   5        $ 	SearchBox��5      $
��Left=�6&   $��40��6A   $	��Top=�6M   $	��163��6e   ���	#FFF2F2F2 5      �� 5      $	��14* �6'   �� 5      $	��11* �6'   .+�5      �� $
��Left=�6   $��30��63   $��42,5,0,0q�6?   $	��Top=�6Q   $��25��6i   $��/Images/searchIcon.png��6t   $��1��6�   �� 5      -   5         ��Name$ 
SearchText��5      $
��Left=�6.   $��30��6I    �� TextWrapping$
 Wrap=�6U   $��Search��6i   $	��123��6w   $��5,5,0,5q�6�   $��2��6�   5      �� 5      $��View Team Invites��6E   $
��Left=�6a   $��
47,372,0,0q�6|   $	��Top=�6�   $	��110��6�   $��35��6�   ��6   �� *NewUserInvitesWindowCommand+6�   �� 5      -   5        $ SettingsIcon��5      $
��Left=�6*   $��35��6E   $��	7,371,0,0q�6Q   $	��Top=�6d   $��/Images/settingIcon.png��6|   $��35��6�    J� RenderTransformOrigin$ 0.505,1.067&�6�   �� 5      $��View Account��6A   $
��Left=�6X   $��35��6s   $��
47,442,0,0q�6   $	��Top=�6�   $	��110��6�   $��Century Gothic)�6�   $��10(�6�   ��6   �� *NewAccountWindowCommand+6�   �� 5       -   5        $ 	EmailIcon��5       $
��Left=�6'   $��35��6B   $��	7,442,0,0q�6N   $	��Top=�6a   $��/Images/userLogo.png��6y   $��35��6�   $ 0.505,1.067&�6�   R� 5"      $
��Left=�6   ���	#FF99CCFF$	��230��6I   $��0,57,0,0q�6V   $	��Top=�6h   $	��163��6�   $��0q�6�   $��16(�6�   .@�5#      Q� $��My Projects��6   .@�5$      Q� $��	Project 1��6#   	 J� InputBindings	 5%      d� 5&      
 d� Gesture$
 LeftDoubleClicka�6+    �� Command 6E   �� *OpenProjectCommand+5'      5)      Q� 5*      $	�� ^ ��6#   62   Q� 5+      $��Double click��6#   6;   Q� 5,      $��Redskinz4Life��6#   6<   Q� 5-      $��	Project 2��6#   68   Q� 5.      $��	Project 3��6#   68   5/      Q� 50      Q� 51      52      �� 53      -   5        $ ProjectIcon��53      $
��Left=�6)   $��35��6D   $	��Top=�6P   $��/Images/folderLogo.png��6h   $��35��6�   $ 0.505,1.067&�6�   $��	7,302,0,0q�6�   �� 54      $��Create Project��6>   $��Right=�6W   $��35��6s   $��Center=�6   $	��110��6�   $��0,302,6,155q�6�   ��6   �� *CreateProjectCommand+6�   55      �� 56   
   -	   5         ��Name$ Stage��56      $��2��6    $��2��61   ._�57      � .+�58      �� $��Welcome ��6   $
��Left=�6+   $��48��6F   $	��Top=�6R   $	��117��6j   $��24(�6v   $��	10,10,0,0q�6�   �� 59      $
��Left=�6A   $��48��6\   $	��Top=�6h   $	��282��6�   $��24(�6�   $��
127,10,0,0q�6�   ��6   �� *CurrentUser.UserName+6�   �� 5:      $����Welcome to the best scrum development system around

 We use this instance to track the development of the system,

 You can create projects and search for existing bug reports here.
 Search for existing bug reports and feature requests
 Use the Search field in the header to find out if someone's already created your bug report or feature request.
 If you find an appropriate issue, watch it to get updates,
 or comment and vote to add your voice.

 Create a new bug report or feature request:
     To report a new bug: Create an issue in our support system.
     The team will work with you to reproduce and verify your report.
     To create a feature request:
     Log in or create an account, then hit Create in the header.
     For anything other than feature requests and bug reports, search our other resources:��6   $
��Left=�5G   [   $	��304��6v   $��	10,90,0,0q�6�   $	��Top=�6�   $	��639��6�   5I      5J      5K      5L      