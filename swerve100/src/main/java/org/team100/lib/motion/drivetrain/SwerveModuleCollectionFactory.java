package org.team100.lib.motion.drivetrain;

import org.team100.frc2023.subsystems.SwerveModuleFactory;
import org.team100.lib.config.Identity;
import org.team100.lib.experiments.Experiments;

/** Creates collections according to Identity. */
public class SwerveModuleCollectionFactory {
    private final Identity identity;
    private final SwerveModuleFactory m_moduleFactory;

    public SwerveModuleCollectionFactory(
            Experiments experiments,
            Identity identity,
            double currentLimit) {
        this.identity = identity;
        m_moduleFactory = new SwerveModuleFactory(experiments, currentLimit);
    }

    public SwerveModuleCollectionInterface get() {
        switch (identity) {
            case COMP_BOT:
                return new SwerveModuleCollection(
                        m_moduleFactory.WCPModule(
                                "Front Left",
                                11, // drive CAN
                                30, // turn CAN
                                0, // turn encoder
                                0.208328), // turn offset
                        m_moduleFactory.WCPModule(
                                "Front Right",
                                12, // drive CAN
                                32, // turn CAN
                                1, // turn encoder
                                0.159267), // turn offset
                        m_moduleFactory.WCPModule(
                                "Rear Left",
                                21, // drive CAN
                                31, // turn CAN
                                2, // turn encoder
                                0.896148), // turn offset
                        m_moduleFactory.WCPModule(
                                "Rear Right",
                                22, // drive CAN
                                33, // turn CAN
                                3, // turn encoder
                                0.609823)); // turn offset
            case SWERVE_TWO:
                return new SwerveModuleCollection(
                        m_moduleFactory.Swerve1CAN(
                                "Front Left",
                                11, // drive CAN
                                5, // turn PWM
                                1, // turn encoder
                                0.911606), // turn offset
                        m_moduleFactory.Swerve1CAN(
                                "Front Right",
                                12, // drive CAN
                                2, // turn PWM
                                3, // turn encoder
                                0.083566), // turn offset
                        m_moduleFactory.Swerve1CAN(
                                "Rear Left",
                                21, // drive CAN
                                3, // turn PWM
                                0, // turn encoder
                                0.871471), // turn offset
                        m_moduleFactory.Swerve1CAN(
                                "Rear Right",
                                22, // drive CAN
                                1, // turn PWM
                                2, // turn encoder
                                0.605593)); // turn offset
            case SWERVE_ONE:
                return new SwerveModuleCollection(
                        m_moduleFactory.AMCANModule(
                                "Front Left",
                                11, // drive CAN
                                5, // turn PWM0
                                2, // turn encoder
                                0.694815), // turn offset
                        m_moduleFactory.AMCANModule(
                                "Front Right",
                                12, // drive CAN
                                2, // turn PWM
                                0, // turn encoder
                                0.718789), // turn offset
                        m_moduleFactory.AMCANModule(
                                "Rear Left",
                                21, // drive CAN
                                3, // turn PWM
                                3, // turn encoder
                                0.365612), // turn offset
                        m_moduleFactory.AMCANModule(
                                "Rear Right",
                                22, // drive CAN
                                1, // turn PWM
                                1, // turn encoder
                                0.942851)); // turn offset
            default:
         return new SwerveModuleCollection.Noop();
            // previously this would throw.
            // throw new IllegalStateException("Identity is not swerve: " +
            // Identity.get().name());
        }
    }

}
