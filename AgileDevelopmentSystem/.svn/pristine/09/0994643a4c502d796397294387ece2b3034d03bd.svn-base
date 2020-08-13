using OxyPlot;
using OxyPlot.Axes;
using OxyPlot.Series;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using WPFClientApplication.ViewModel;

namespace EasyWpfLoginNavigateExample.ViewModel.Sprints
{
    class TeamBurnDownViewModel : ViewModelBase
    {

        private String yaxisTitle = "Remaining Effort Hours";
        private String xaxisTitle = "Sprint Dates";

        public TeamBurnDownViewModel()
        {
            this.Points = new List<DataPoint>
                              {
                                  new DataPoint(0, 14),
                                  new DataPoint(14, 10)
                              };
            this.testPoints = new List<DataPoint>
                              {
                                  new DataPoint(0, 14),
                                  new DataPoint(4, 14),
                                  new DataPoint(14, 0)
                              };

        }


        public IList<DataPoint> Points { get; private set; }
        public IList<DataPoint> testPoints { get; private set; }

    }
}
