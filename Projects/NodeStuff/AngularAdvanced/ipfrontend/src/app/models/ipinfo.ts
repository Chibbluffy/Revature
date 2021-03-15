export class Ipinfo {
    constructor(
        public status:      string="",
        public country:     string="",
        public countryCode: string="",
        public region:      string="",
        public regionName:  string="",
        public city:        string="",
        public zip:         string="",
        public lat:         number=0,
        public lon:         number=-0,
        public timezone:    string="",
        public isp:         string="",
        public org:         string="",
        public as:          string="",
        public query:       string="0.0.0.0"){}
}
