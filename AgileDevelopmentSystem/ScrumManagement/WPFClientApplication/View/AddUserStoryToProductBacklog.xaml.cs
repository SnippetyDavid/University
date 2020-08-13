﻿using EasyWpfLoginNavigateExample.ViewModel.Sprints;
using SharedModelLibrary;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace EasyWpfLoginNavigateExample.View
{
    /// <summary>
    /// Interaction logic for AddUserStoryToProductBaclog.xaml
    /// </summary>
    public partial class AddUserStoryToProductBaclog : Window
    {
        public AddUserStoryToProductBaclog()
        {
            InitializeComponent();
            DataContext = new ProductBacklogViewModel(1);
        }
    }
}