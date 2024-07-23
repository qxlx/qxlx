//package com.qxlx.spingboot.aspect;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import javassist.bytecode.SignatureAttribute;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.core.DefaultParameterNameDiscoverer;
//import org.springframework.stereotype.Component;
//
//import java.lang.reflect.Method;
//
///**
// * @author qxlx
// * @date 2024/7/10 07:27
// */
//@Aspect
//@Component
//@Slf4j
//public class MethodAspect {
//
//    @Around("@annotation(com.atguigu.interview2.annotations.MethodExporter)")
//    public Object methodExporter(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        Object retValue = null;
//
//        long startTime = System.currentTimeMillis();
//        System.out.println("-----@Around环绕通知AAA-methodExporter");
//
//        retValue = proceedingJoinPoint.proceed(); //放行
//
//        long endTime = System.currentTimeMillis();
//        long costTime = endTime - startTime;
//
//        //1 获得重载后的方法名
//        SignatureAttribute.MethodSignature signature = (SignatureAttribute.MethodSignature) proceedingJoinPoint.getSignature();
//        Method method = signature.getMethod();
//
//        //2 确定方法名后获得该方法上面配置的注解标签MyRedisCache
//        MethodExporter methodExporterAnnotation = method.getAnnotation(MethodExporter.class);
//
//        if (methodExporterAnnotation != null)
//        {
//            //3 获得方法里面的形参信息
//            StringBuffer jsonInputParam = new StringBuffer();
//            Object[] args = proceedingJoinPoint.getArgs();
//            DefaultParameterNameDiscoverer discoverer = new DefaultParameterNameDiscoverer();
//            String[] parameterNames = discoverer.getParameterNames(method);
//            for (int i = 0; i < parameterNames.length; i++)
//            {
//                jsonInputParam.append(parameterNames[i] + "\t" + args[i].toString()+";");
//            }
//            //4 将返回结果retValue序列化
//            String jsonResult = null;
//            if(retValue != null){
//                jsonResult = new ObjectMapper().writeValueAsString(retValue);
//            }else{
//                jsonResult = "null";
//            }
//
//            log.info("\n方法分析上报中 " +
//                    "\n类名方法名:"+proceedingJoinPoint.getTarget().getClass().getName()+"."+proceedingJoinPoint.getSignature().getName()+"()"+
//                    "\n执行耗时:"+costTime+"毫秒"+
//                    "\n输入参数:"+jsonInputParam+""+
//                    "\n返回结果:"+jsonResult+"" +
//                    "\nover"
//            );
//            System.out.println("-----@Around环绕通知BBB-methodExporter");
//        }
//
//        return retValue;
//
//
//    }
//
//}
