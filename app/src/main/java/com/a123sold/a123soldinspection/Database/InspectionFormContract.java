package com.a123sold.a123soldinspection.Database;

import android.provider.BaseColumns;

/**
 * Created by akshit on 28/7/16.
 */
public final class InspectionFormContract {

    public static abstract class FormFeedEntry implements BaseColumns {

        public static final String COLUMN_NAME_CARID = "car_id";


        public static final String TABLE_NAME_EXTERIOR = "exterior";
        public static final String COLUMN_NAME_GRILLINSPECTION= "grillinspection";
        public static final String COLUMN_NAME_TRIMINSPECTION = "triminspection";
        public static final String COLUMN_NAME_ROOFRACKINSPECTION = "roofrackinspection";
        public static final String COLUMN_NAME_DEPLOYABLERUNNINGBOARDS = "deployablerunningboards";
        public static final String COLUMN_NAME_WINDSHIELDGLASSINSPECTION = "windshieldglassinspection";
        public static final String COLUMN_NAME_SIDEGLASSINSPECTION = "sideglassinspection";
        public static final String COLUMN_NAME_REARWINDOWGLASSINSPECTION = "rearwindowglassinspection";
        public static final String COLUMN_NAME_WIPERBLADE = "wiperblade";
        public static final String COLUMN_NAME_OUTSIDEMIRRORINSPECTION = "outsidemirrorinspection";
        public static final String COLUMN_NAME_OUTSIDEFOLDINGMIRRORINSPECTION = "outsidefoldingmirrorinspection";
        public static final String COLUMN_NAME_FRONTEXTLIGHTS = "frontextlights";
        public static final String COLUMN_NAME_BACKEXTLIGHTS = "backextlights";
        public static final String COLUMN_NAME_SIDEEXTLIGHTS= "sideextlights";
        public static final String COLUMN_NAME_HAZARDLIGHTS = "hazardlights";
        public static final String COLUMN_NAME_TRAILERLAMPCONNECTOR = "trailerlampconnector";
        public static final String COLUMN_NAME_ONOFFLIGHTING = "onofflighting";
        public static final String COLUMN_NAME_FLOODDAMAGE = "flooddamage";
        public static final String COLUMN_NAME_FIREDAMAGE = "firedamage";
        public static final String COLUMN_NAME_MAJORDAMAGE = "majordamage";
        public static final String COLUMN_NAME_HAILDAMAGE = "haildamage";
        public static final String COLUMN_NAME_BODYPANEL = "bodypanel";
        public static final String COLUMN_NAME_BUMPER= "bumper";
        public static final String COLUMN_NAME_DOORS = "doors";
        public static final String COLUMN_NAME_HOOD = "hood";
        public static final String COLUMN_NAME_DECKLID= "decklid";
        public static final String COLUMN_NAME_TAILGATE = "tailgate";
        public static final String COLUMN_NAME_ROOF = "roof";
        public static final String COLUMN_NAME_HOODRELEASE = "hoodrelease";
        public static final String COLUMN_NAME_HOODHINGES = "hoodhinges";
        public static final String COLUMN_NAME_DOORHINGES = "doorhinges";
        public static final String COLUMN_NAME_TRUNKSTRUTS = "trunkstruts";
        public static final String COLUMN_NAME_POWERLIFTGATE = "powerliftgate";
        public static final String COLUMN_NAME_PAINTGAUGE = "paintgauge";
        public static final String COLUMN_NAME_REPAIRINGCOSTEXTERIOR = "repairingcost";
        public static final String COLUMN_NAME_COMMENTEXTERIOR = "comment";

        public static final String TABLE_NAME_HYBRID = "hybrid";
        public static final String COLUMN_NAME_HYBRIDCOOLINGSYSTEM = "hybridcoolingsystem";
        public static final String COLUMN_NAME_SWITCHABLEPOWERTRAINMOUNT = "switchablepowertrainmount";
        public static final String COLUMN_NAME_HYBRIDENTERTAINMENTANDINFORMATIONDISPLAY = "hybridentertainment";
        public static final String COLUMN_NAME_POWEROUTLET = "poweroutlet";
        public static final String COLUMN_NAME_REPAIRINGCOSTHYBRID = "repairingcost";
        public static final String COLUMN_NAME_COMMENTHYBRID = "comment";

        public static final String TABLE_NAME_CONVIENCE="convience";
        public static final String COLUMN_NAME_OWNERSGUIDE = "ownersguide";
        public static final String COLUMN_NAME_KEYREMOTECONTROLS = "keyremotecontrols";
        public static final String COLUMN_NAME_UNIVERSALTRANSMITTER = "universaltransmitter";
        public static final String COLUMN_NAME_RC = "rc";
        public static final String COLUMN_NAME_POLLUTIONCERTI = "pollutioncerti";
        public static final String COLUMN_NAME_COMPANY = "company";
        public static final String COLUMN_NAME_INSAURANCEVALIDITY = "insvalidity";
        public static final String COLUMN_NAME_LIFETAXPAID = "lifetaxpaid";
        public static final String COLUMN_NAME_LEASE = "lease";
        public static final String COLUMN_NAME_NAMEFINANCIALCORPORATION = "namefinancialcorporation";
        public static final String COLUMN_NAME_REPAIRINGCOSTCONVIENCE = "repairingcost";
        public static final String COLUMN_NAME_COMMENTCONVIENCE = "comment";

        public static final String TABLE_NAME_HISTORY="history";
        public static final String COLUMN_NAME_VIN = "vinins";
        public static final String COLUMN_NAME_SERVICERECALL = "servicerecall";
        public static final String COLUMN_NAME_VEHICLEHISTORYREPORT = "vehiclehistoryreport";
        public static final String COLUMN_NAME_SCHEDULEDMAINTENANCE = "scheduledmaintenance";
        public static final String COLUMN_NAME_VEHICLEEMISSIONS = "vehicleemissions";
        public static final String COLUMN_NAME_REPAIRINGCOSTHISTORY = "repairingcost";
        public static final String COLUMN_NAME_COMMENTHISTORY = "comment";

        public static final String TABLE_NAME_INTERIOR="interior";
        public static final String COLUMN_NAME_AIRBAGS= "airbags";
        public static final String COLUMN_NAME_SAFTEYBELTS = "safteybelts";
        public static final String COLUMN_NAME_STEREOANDSPEAKERS = "stereoandspeakers";
        public static final String COLUMN_NAME_ANTENNA = "antenna";
        public static final String COLUMN_NAME_ALARMSYSTEM = "alarmsystem";
        public static final String COLUMN_NAME_NAVIGATIONSYSTEM = "navigationsystem";
        public static final String COLUMN_NAME_AIRCONDITIONINGSYSTEM = "airconditioningsystem";
        public static final String COLUMN_NAME_HEATINGSYSTEM = "heatingsystem";
        public static final String COLUMN_NAME_DEFOG = "defog";
        public static final String COLUMN_NAME_CLOCK = "clock";
        public static final String COLUMN_NAME_TILTSTEERINGWHEEL = "tiltsteeringwheel";
        public static final String COLUMN_NAME_STEERINGCOLUMNLOCK = "steeringcolumnlock";
        public static final String COLUMN_NAME_STEERINGWHEELCONTROLS= "steeringwheelcontrol";
        public static final String COLUMN_NAME_HORN = "horn";
        public static final String COLUMN_NAME_WARNINGCHIMES = "warningchimes";
        public static final String COLUMN_NAME_INSTRUMENTPANELANDWARNINGLIGHT = "warninglight";
        public static final String COLUMN_NAME_WINDSHEILDWIPERS= "windsheildwipers";
        public static final String COLUMN_NAME_REARWINDOWWIPER = "rearwindowwiper";
        public static final String COLUMN_NAME_WASHERS = "washers";
        public static final String COLUMN_NAME_MAPLIGHTS = "maplights";
        public static final String COLUMN_NAME_OUTSIDEREARVIEWMIRRORS = "rearviewmirrors";
        public static final String COLUMN_NAME_AUTODIMMINGREARVIEW = "autodimmingrearview";
        public static final String COLUMN_NAME_BLINDSPOT= "blindspot";
        public static final String COLUMN_NAME_REARCAMERA = "rearcamera";
        public static final String COLUMN_NAME_ACTIVEPARKASSIST = "activeparkassist";
        public static final String COLUMN_NAME_REARENTERTAINMENTSYSTEM= "rearentertainmentsystem";
        public static final String COLUMN_NAME_POWEROUTLETS = "poweroutlets";
        public static final String COLUMN_NAME_LIGHTER = "lighter";
        public static final String COLUMN_NAME_ASHTRAYS = "ashtrays";
        public static final String COLUMN_NAME_GLOVEBOX = "glovebox";
        public static final String COLUMN_NAME_CENTERCONSOLEFRONT= "centerconsolefront";
        public static final String COLUMN_NAME_CENTERCONSOLEFREAR= "centerconsolerear";
        public static final String COLUMN_NAME_SUNVISORS = "sunvisors";
        public static final String COLUMN_NAME_ADJUSTABLEPEDALS = "adjustablepedals";
        public static final String COLUMN_NAME_INTERIORODOR = "interiorrodor";
        public static final String COLUMN_NAME_CARPET = "carpet";
        public static final String COLUMN_NAME_FLOODMATS= "floodmats";
        public static final String COLUMN_NAME_DOORTRIM = "doortrim";
        public static final String COLUMN_NAME_HEADLINER = "headliner";
        public static final String COLUMN_NAME_SEATUPHOLDSTERY = "seatupholdstery";
        public static final String COLUMN_NAME_SEATANDHEAD = "seatandhead";
        public static final String COLUMN_NAME_FOLDINGSEATS= "foldingseats";
        public static final String COLUMN_NAME_HEATEDSEATS = "heatedseats";
        public static final String COLUMN_NAME_COOLEDSEATS = "cooledseats";
        public static final String COLUMN_NAME_CONVERTIBLETOP= "convertibletop";
        public static final String COLUMN_NAME_SUNROOF = "sunroof";
        public static final String COLUMN_NAME_DOORHANDLES = "doorhandles";
        public static final String COLUMN_NAME_REMOTEENTRY = "remoteentry";
        public static final String COLUMN_NAME_PUSHBUTTONSTART = "pushbuttonstart";
        public static final String COLUMN_NAME_DOORLOCKS= "doorlocks";
        public static final String COLUMN_NAME_CHILDSAFTEYLOCKS = "childsafteylocks";
        public static final String COLUMN_NAME_WINDOWCONTROLS = "windowcontrols";
        public static final String COLUMN_NAME_REMOTEDECKLID = "remotedecklid";
        public static final String COLUMN_NAME_FUELFILLERDOOR = "fuelfillerdoor";
        public static final String COLUMN_NAME_CARPETLUGGAGE = "carpetluggage";
        public static final String COLUMN_NAME_CARGONET= "cargonet";
        public static final String COLUMN_NAME_CARGOAREALIGHT = "arealight";
        public static final String COLUMN_NAME_JACKTOOLKIT = "jacktoolkit";
        public static final String COLUMN_NAME_SIDEWALLINS = "sidewallins";
        public static final String COLUMN_NAME_PRESSUREINS = "pressureins";
        public static final String COLUMN_NAME_TIREKIT= "tirekit";
        public static final String COLUMN_NAME_LIDRELEASE = "lidrelease";
        public static final String COLUMN_NAME_REPAIRINGCOSTINTERIOR = "repairingcost";
        public static final String COLUMN_NAME_COMMENTINTERIOR = "comment";

        public static final String TABLE_NAME_ROADTEST="roadtest";
        public static final String COLUMN_NAME_ENGINESTARTPROPERLY = "enginestartproperly";
        public static final String COLUMN_NAME_ENGINEIDLESPROPERLY = "engineidlesproperly";
        public static final String COLUMN_NAME_REMOTESTARTSYSTEM = "remotestartsystem";
        public static final String COLUMN_NAME_ENGINEACCELERATES = "engineaccelerates";
        public static final String COLUMN_NAME_ENGINENOISE = "enginenoise";
        public static final String COLUMN_NAME_TRANSAXLEOPERATION = "transaxleoperation";
        public static final String COLUMN_NAME_TRANSAXLENOISENORMAL = "transaxlenoisenormal";
        public static final String COLUMN_NAME_SHIFTINTERLOCK = "shiftinterlock";
        public static final String COLUMN_NAME_DRIVEAXLE = "driveaxle";
        public static final String COLUMN_NAME_CLUTCHOPERATE = "clutchoperates";
        public static final String COLUMN_NAME_STEERSNORMALLY = "steersnormally";
        public static final String COLUMN_NAME_BODYSQUEAKS = "bodysqueaks";
        public static final String COLUMN_NAME_SHOCKESOPERATES = "shocksoperates";
        public static final String COLUMN_NAME_BRAKESOPERATES = "brakeoperates";
        public static final String COLUMN_NAME_CRUISECONTROL = "cruisecontrol";
        public static final String COLUMN_NAME_GAUGESOPERATEPROPERLY = "gaugesoperateproperly";
        public static final String COLUMN_NAME_MEMORYPROFILESYSTEM = "memoryprofilesystem";
        public static final String COLUMN_NAME_NOWINDNOISE = "nowindnoise";
        public static final String COLUMN_NAME_REPAIRINGCOSTROADTEST = "repairingcost";
        public static final String COLUMN_NAME_COMMENTROADTEST = "comment";

        public static final String TABLE_NAME_UNDERHOOD="underhood";
        public static final String COLUMN_NAME_ENGINEOIL = "engineoil";
        public static final String COLUMN_NAME_CHASISTUBE = "chasistube";
        public static final String COLUMN_NAME_COOLANT = "coolant";
        public static final String COLUMN_NAME_BRAKEFLUID = "brakefluid";
        public static final String COLUMN_NAME_TRANSAXLEFLUID = "transaxlefluid";
        public static final String COLUMN_NAME_TRANSFERCASEFUID = "transfercasefluid";
        public static final String COLUMN_NAME_DRIVEAXLEFLUID = "driveaxlefluid";
        public static final String COLUMN_NAME_POWERSTEERINGFLUID = "powersteeringfluid";
        public static final String COLUMN_NAME_MANUALTRANSFLUID = "manualtransfluid";
        public static final String COLUMN_NAME_WASHERFLUID = "washerfluid";
        public static final String COLUMN_NAME_AIRCONDITIONINGSYSTEMCHARGE = "airconditioningsystemcharge";
        public static final String COLUMN_NAME_FLUIDLEAKS = "fluidleaks";
        public static final String COLUMN_NAME_HOSESLINESFITTINGS = "hoseslinesfittings";
        public static final String COLUMN_NAME_BELTS = "belts";
        public static final String COLUMN_NAME_WIRING = "wiring";
        public static final String COLUMN_NAME_OILINAIRCLEANSER = "oilinaircleanser";
        public static final String COLUMN_NAME_WATERSLUDGEOIL = "watersludgeoil";
        public static final String COLUMN_NAME_OILPRESSURE = "oilpressure";
        public static final String COLUMN_NAME_RELATIVECYLENDIRCOMPRESSION = "relativecylendircompression";
        public static final String COLUMN_NAME_TIMINGBELT = "timingbelt";
        public static final String COLUMN_NAME_ENGINEMOUNTS = "enginemounts";
        public static final String COLUMN_NAME_TURBOCHARGERAIRCOOLER = "turbochargeraircooler";
        public static final String COLUMN_NAME_RADIATOR = "radiator";
        public static final String COLUMN_NAME_RADIATORCAP = "radiatorcap";
        public static final String COLUMN_NAME_COOLINGFANS = "coolingfans";
        public static final String COLUMN_NAME_WATERPUMP = "waterpump";
        public static final String COLUMN_NAME_COOLANTRECOVERYTANK = "coolantrecoverytank";
        public static final String COLUMN_NAME_CABINAIRFILTER = "cabinairfilter";
        public static final String COLUMN_NAME_FUELPUMPNOISENORMAL = "fuelpumpnoisenormal";
        public static final String COLUMN_NAME_FUELPUMPPRESSURE = "fuelpumppressure";
        public static final String COLUMN_NAME_FUELFILTER = "fuelfilter";
        public static final String COLUMN_NAME_ENGINEAIRFILTER = "engineairfilter";
        public static final String COLUMN_NAME_STARTEROPERATION = "starteroperation";
        public static final String COLUMN_NAME_IGNITIONSYSTEM = "ignitionsystem";
        public static final String COLUMN_NAME_BATTERY = "battery";
        public static final String COLUMN_NAME_ALTERNATOROUTPUT = "alternatoroutput";
        public static final String COLUMN_NAME_DIESELGLOWPLUGSYSTEM = "dieselglowplugsystem";
        public static final String COLUMN_NAME_REPAIRINGCOSTUNDERHOOD = "repairingcost";
        public static final String COLUMN_NAME_COMMENTUNDERHOOD = "comment";


        public static final String TABLE_NAME_UNDERBODY="underbody";
        public static final String COLUMN_NAME_FRAMEDAMAGE = "framedamage";
        public static final String COLUMN_NAME_FUELSUPPLYSYSTEM = "fuelsupplysystem";
        public static final String COLUMN_NAME_EXHAUSTSYSTEMCONDITION = "exhaustsystemcondition";
        public static final String COLUMN_NAME_EMISSIONSCONTROLTEST = "emissionscontroltest";
        public static final String COLUMN_NAME_AUTOMATICTRANSMISSION = "automatictransmission";
        public static final String COLUMN_NAME_MANUALTRANSMISSION= "manualtransmission";
        public static final String COLUMN_NAME_HUBOPERATION = "huboperation";
        public static final String COLUMN_NAME_UNIVERSALJOINTS = "universaljoints";
        public static final String COLUMN_NAME_TRANSMISSIONMOUNTS = "transmissionmounts";
        public static final String COLUMN_NAME_DIFFERNTIALDRIVEAXLE = "differentialdriveaxle";
        public static final String COLUMN_NAME_TIRESMATCH = "tiresmatch";
        public static final String COLUMN_NAME_WHEELSMATCH = "wheelsmatch";
        public static final String COLUMN_NAME_TIREDEPTHFRONT = "tiredepthfront";
        public static final String COLUMN_NAME_TIREDEPTHREAR = "tiredepthrare";
        public static final String COLUMN_NAME_NORMALTIREWEAR = "normaltirewear";
        public static final String COLUMN_NAME_TIREPRESSUREFRONT = "tirepressurefront";
        public static final String COLUMN_NAME_TIREPRESSUREBACK = "tirepressureback";
        public static final String COLUMN_NAME_TIREPRESSUREMONITOR = "tirepressuremonitor";
        public static final String COLUMN_NAME_WHEELS = "wheels";
        public static final String COLUMN_NAME_WHEELCOVERANDCENTERCAPS = "wheelcovercentercaps";
        public static final String COLUMN_NAME_RACKPINION = "rackpinion";
        public static final String COLUMN_NAME_CONTROLARMS = "controlarms";
        public static final String COLUMN_NAME_TIERODS = "tierods";
        public static final String COLUMN_NAME_SWAYBARS = "swaybars";
        public static final String COLUMN_NAME_SPRINGS = "springs";
        public static final String COLUMN_NAME_STRUTSANDSHOCKS = "strutsandshocks";
        public static final String COLUMN_NAME_WHEELALIGNMENT = "wheelalignment";
        public static final String COLUMN_NAME_POWERSTEERINGPUMP = "powersteeringpump";
        public static final String COLUMN_NAME_WHEELSCYLENDIRS = "wheelscylendirs";
        public static final String COLUMN_NAME_BRAKEPADFRONT = "breakpadfront";
        public static final String COLUMN_NAME_BRAKEPADREAR = "breakpadrear";
        public static final String COLUMN_NAME_ROTORSANDDRUMS= "rotorsanddrums";
        public static final String COLUMN_NAME_BRAKELINES = "brakelines";
        public static final String COLUMN_NAME_PARKINGBRAKE = "parkingbrake";
        public static final String COLUMN_NAME_MASTERCYLENDIRBOOSTER = "mastercylendirbooster";
        public static final String COLUMN_NAME_REPAIRINGCOSTUNDERBODY = "repairingcost";
        public static final String COLUMN_NAME_COMMENTUNDERBODY = "comment";

        public static final String TABLE_NAME_DIAGNOSTICS="diagnostics";

        public static final String ALL_COLUMN_EXTERIOR[]={
        COLUMN_NAME_GRILLINSPECTION,
        COLUMN_NAME_TRIMINSPECTION,
        COLUMN_NAME_ROOFRACKINSPECTION,
        COLUMN_NAME_DEPLOYABLERUNNINGBOARDS,
        COLUMN_NAME_WINDSHIELDGLASSINSPECTION,
        COLUMN_NAME_SIDEGLASSINSPECTION,
        COLUMN_NAME_REARWINDOWGLASSINSPECTION,
        COLUMN_NAME_WIPERBLADE,
        COLUMN_NAME_OUTSIDEMIRRORINSPECTION,
        COLUMN_NAME_OUTSIDEFOLDINGMIRRORINSPECTION,
        COLUMN_NAME_FRONTEXTLIGHTS,
        COLUMN_NAME_BACKEXTLIGHTS,
        COLUMN_NAME_SIDEEXTLIGHTS,
        COLUMN_NAME_HAZARDLIGHTS,
        COLUMN_NAME_TRAILERLAMPCONNECTOR,
        COLUMN_NAME_ONOFFLIGHTING,
        COLUMN_NAME_FLOODDAMAGE,
        COLUMN_NAME_FIREDAMAGE,
        COLUMN_NAME_MAJORDAMAGE,
        COLUMN_NAME_HAILDAMAGE,
        COLUMN_NAME_BODYPANEL,
        COLUMN_NAME_BUMPER,
        COLUMN_NAME_DOORS,
        COLUMN_NAME_HOOD,
        COLUMN_NAME_DECKLID,
        COLUMN_NAME_TAILGATE,
        COLUMN_NAME_ROOF,
        COLUMN_NAME_HOODRELEASE,
        COLUMN_NAME_HOODHINGES,
        COLUMN_NAME_DOORHINGES,
        COLUMN_NAME_TRUNKSTRUTS,
        COLUMN_NAME_POWERLIFTGATE,
        COLUMN_NAME_PAINTGAUGE,
        COLUMN_NAME_REPAIRINGCOSTEXTERIOR,
        COLUMN_NAME_COMMENTEXTERIOR
        };

    }
}
