using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace SharedModelLibrary
{
    public class NewSprintModel
    {
        public string SprintName { get; set; }
        public int ProjectId { get; set; }
        public int WorkHours { get; set; }
        public DateTime StartDate { get; set; }
        public DateTime EndDate { get; set; }
    }
}
