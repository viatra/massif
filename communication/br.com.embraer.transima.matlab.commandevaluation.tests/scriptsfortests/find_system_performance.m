function cpu_time = find_system_performance(option1)
%WARNING: DATA TYPES LIKE STRUCT AND FUNCTION HANDLE WILL NOT BE TESTED!

switch option1
    case 1 
        model_name = 'topology_loadtest';
        load_system(model_name)
        tic
        find_system(model_name,'UserData',struct('EFTG',struct('uuid','a')));
        cpu_time = toc;
        close_system(model_name,0);
    case 10
        model_name = 'topology_loadtest_10';
        load_system(model_name)        
        tic
        for I = 1:100000,
            x = I;
        end
        find_system(model_name,'UserData',struct('EFTG',struct('uuid','a')));
        cpu_time = toc;
        close_system(model_name,0);

    case 50
        model_name = 'topology_loadtest_50';
        load_system(model_name)        
        tic
        for I = 1:100000,
            x = I;
        end        
        find_system(model_name,'UserData',struct('EFTG',struct('uuid','a')));
        cpu_time = toc;
        close_system(model_name,0);
      
    case 100
        model_name = 'topology_loadtest_100';
        load_system(model_name)      
        tic
        for I = 1:100000,
            x = I;
        end        
        find_system(model_name,'UserData',struct('EFTG',struct('uuid','a')));
        cpu_time = toc;
        close_system(model_name,0);
        
    otherwise
        cpu_time = 0;
end
end
