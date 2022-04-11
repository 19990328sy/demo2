package com.example.demo.service.impl;

import com.example.demo.TimeParent.TimeParent;
import com.example.demo.mapper.INdustrialValueAddMapper;
import com.example.demo.model.INdustrialValueAdd;
import com.example.demo.service.INdustrialValueAddService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class INdustrialValueAddServiceImpl implements INdustrialValueAddService {

    @Autowired
    private INdustrialValueAddMapper ndustrialValueAddMapper;

    @Override
    public List<INdustrialValueAdd> selectDust(TimeParent timeParent) {
        return ndustrialValueAddMapper.selectDust ( timeParent );
    }

    @Override
    public Map findDateDust(TimeParent timeParent) {
        SimpleDateFormat sfg = new SimpleDateFormat ( "yyyy" );
        Map data = new HashMap ();
        Map times = new HashMap ();
        Map scaleValueAdd = new HashMap ();
        Map scaleValueRate = new HashMap ();
        Map provincesRate = new HashMap ();
        Map countryRate = new HashMap ();
        List<INdustrialValueAdd> ndustrialValueAdds = ndustrialValueAddMapper.selectDust ( timeParent );
        List<String> listYear = new ArrayList<> ();
        List<String> listScaleValueAdd = new ArrayList<> ();
        List<String> listScaleValueRate = new ArrayList<> ();
        List<String> listProvincesRate = new ArrayList<> ();
        List<String> listCountryRate = new ArrayList<> ();
        if ( !ndustrialValueAdds.isEmpty () ) {
            for (INdustrialValueAdd ndustrialValueAdd : ndustrialValueAdds) {
                //获取年份
                listYear.add ( sfg.format ( ndustrialValueAdd.getStatYear () ) );
                //获取规模以上工业增值
                listScaleValueAdd.add ( sfg.format ( ndustrialValueAdd.getScaleValueAdd () ) );
                listScaleValueRate.add ( sfg.format ( ndustrialValueAdd.getScaleValueRate () ) );
                listProvincesRate.add ( sfg.format ( ndustrialValueAdd.getProvincesRate () ) );
                listCountryRate.add ( sfg.format ( ndustrialValueAdd.getCountryRate () ) );
            }
            data.put ( "list", ndustrialValueAdds );
            times.put ( "time", listYear );
            times.put ( "type", "X" );
            data.put ( "times", times );

            List<Map> dataAll = new ArrayList<> ();
            scaleValueAdd.put ( "name","规模以上工业增值" );
            scaleValueAdd.put ( "type","bar" );
            scaleValueAdd.put ( "type","X" );
            scaleValueAdd.put ( "data",listScaleValueAdd );
            dataAll.add ( scaleValueAdd );

            scaleValueRate.put ( "name","规模以上工业增值增长率" );
            scaleValueRate.put ( "type","line" );
            scaleValueRate.put ( "type","X" );
            scaleValueRate.put ( "data",listScaleValueRate );
            dataAll.add ( scaleValueRate );

            provincesRate.put ( "name","全省规模以上工业增值增长率" );
            provincesRate.put ( "type","line" );
            provincesRate.put ( "type","X" );
            provincesRate.put ( "data",listProvincesRate );
            dataAll.add ( provincesRate );

            countryRate.put ( "name","全国规模以上工业增值增长率" );
            countryRate.put ( "type","line" );
            countryRate.put ( "type","X" );
            countryRate.put ( "data",listCountryRate );
            dataAll.add ( countryRate );

        }
        return data;
    }
}
